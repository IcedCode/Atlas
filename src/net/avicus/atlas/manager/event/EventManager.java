package net.avicus.atlas.manager.event;

import lombok.Getter;
import net.avicus.atlas.chat.Console;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.check.RegionCheck;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.elements.event.Damage;
import net.avicus.atlas.xml.elements.event.GameEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.ArrayList;
import java.util.List;

public class EventManager extends Manager {

    @Getter List<Check> checks = new ArrayList<Check>();

    public EventManager(Match match) {
        super(match);
        checks.add(new RegionCheck());
    }

    public boolean check(GameEvent event, List<Check> checks, Object value) {
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

    public <T extends GameEvent> List<T> getEvents(Class<T> type) {
        List<T> list = new ArrayList<T>();
        for (GameEvent event : match.getMap().getEvents())
            if (event.getClass() == type)
                list.add((T) event);
        return list;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        List<Damage> events = getEvents(Damage.class);

        for (Damage damage : events) {
            if (check(damage, checks, event.getEntity().getLocation())) {
                event.setCancelled(true);
            }
        }
    }

}
