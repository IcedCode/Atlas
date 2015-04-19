package net.avicus.atlas.rotation;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.Task;

import java.util.List;

@ToString
public class Rotation {

    @Getter final List<Match> matches;

    private int index = 0;

    public Rotation(List<Match> matches) {
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
