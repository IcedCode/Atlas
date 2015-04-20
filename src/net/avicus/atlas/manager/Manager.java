package net.avicus.atlas.manager;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.Task;

import java.util.List;

@ToString
public class Manager {

    @Getter static Manager manager;

    @Getter final List<Match> matches;

    private int index = 0;

    public Manager(List<Match> matches) {
        manager = this;
        this.matches = matches;
    }

    public void begin() throws Exception {
        getMatch().prepare();
        getMatch().load();
    }

    public Match getMatch() {
        return matches.get(index);
    }

    public Match getNextMatch() {
        return matches.get(index + 1);
    }

    public void start() {
        getMatch().start();
    }

    public void end() {
        getMatch().end();

        new Task() {
            @Override
            public void run() throws Exception {
                getNextMatch().prepare();
            }
        }.nowAsync();
    }

    public void cycle() {
        new Task() {
            @Override
            public void run() throws Exception {
                getNextMatch().load();
            }
        }.nowAsync();
    }

}
