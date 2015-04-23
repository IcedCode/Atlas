package net.avicus.atlas.manager.event;

import lombok.Getter;
import net.avicus.atlas.event.VariablesRequestEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.check.RegionCheck;
import net.avicus.atlas.manager.event.handler.CancelEventHandler;
import net.avicus.atlas.manager.event.handler.TeleportPlayerHandler;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.EventUtils;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.elements.event.GameEvent;
import net.avicus.atlas.xml.elements.event.action.Action;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings(value = "unchecked")
public class EventManager extends Manager {

    @Getter List<Check> checks = new ArrayList<Check>();
    @Getter List<Handler> handlers = new ArrayList<Handler>();

    public EventManager(Match match) {
        super(match);

        // Checks
        checks.add(new RegionCheck());

        // Handlers
        handlers.add(new CancelEventHandler(this));
        handlers.add(new TeleportPlayerHandler(this));
    }

    public Variables getVariables(GameEvent event) {
        Variables vars = new Variables();

        VariablesRequestEvent call = EventUtils.call(new VariablesRequestEvent(event, vars));

        return call.getVariables();
    }

    public boolean check(GameEvent event, Object value) {
        if (event.getCondition() == null)
            return true;

        boolean passed = true;

        for (Condition condition : event.getCondition().getList()) {
            for (Check check : checks) {
                if (check.getConditionType() != condition.getClass())
                    continue;

                CheckResult result = check.check(condition, value);
                if (result == CheckResult.IGNORE)
                    continue;

                passed = result == CheckResult.SUCCESS;
            }
        }

        return passed;
    }

    public void handleActions(GameEvent event, Variables variables) {
        for (Action action : event.getActions()) {
            Object input = variables.get(action.getVar());

            // todo: implement warning to map developers instead of exception that halts the server
            if (input == null)
                throw new RuntimeException(event.getClass().getSimpleName() + " couldn't pass " + variables.toString() + " to action " + action.getClass().getSimpleName());

            for (Handler handler : handlers) {
                if (handler.getVar() != null && !handler.getVar().equals(action.getVar()))
                    continue;
                if (handler.getActionType() != action.getClass())
                    continue;
                if (handler.getObjectType() != input.getClass())
                    continue;

                handler.handle(action, input);
                break;
            }
        }


    }

    public <T extends GameEvent> List<T> getEvents(Class<T> type) {
        List<T> list = new ArrayList<T>();
        for (GameEvent event : match.getMap().getEvents())
            if (event.getClass() == type)
                list.add((T) event);
        return list;
    }

}
