package net.avicus.atlas.manager.state;

import lombok.Getter;
import net.avicus.atlas.chat.Console;
import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.event.MatchCloseEvent;
import net.avicus.atlas.event.MatchOpenEvent;
import net.avicus.atlas.event.MatchStateChangeEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.EventUtils;
import net.avicus.atlas.util.Task;
import net.avicus.atlas.xml.elements.State;
import org.bukkit.event.EventHandler;

import java.util.List;

public class StateManager extends Manager {

    private Task timeTask;
    private int current = 0;

    @Getter int time = 0;

    public StateManager(Match match) {
        super(match);

        this.timeTask = new Task() {
            @Override
            public void run() throws Exception {
                time += 1;
            }
        };
    }

    public void setState(int index) {
        State previous = getState();

        current = 1;
        time = 0;

        MatchStateChangeEvent call = EventUtils.call(new MatchStateChangeEvent(match, previous, getState()));
    }

    public void next() {
        setState(current + 1);
    }

    public State getState() {
        return getStates().get(current);
    }

    public List<State> getStates() {
        return match.getMap().getStates();
    }

    @EventHandler
    public void onMatchOpen(MatchOpenEvent event) {
        MatchStateChangeEvent call = EventUtils.call(new MatchStateChangeEvent(match, null, getState()));

        timeTask.repeatAsync(0, 20);
    }

    @EventHandler
    public void onMatchClose(MatchCloseEvent event) {
        timeTask.cancel();
    }

    @EventHandler
    public void onMatchStateChange(MatchStateChangeEvent event) {
        Console.log(Lang.CONSOLE_STATE_CHANGE.with(event.getFrom(), event.getTo()));
    }

}
