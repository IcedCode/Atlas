package net.avicus.atlas.rotation;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.Task;

import java.util.List;

@ToString
public class Rotation {

    @Getter static Rotation rotation;

    @Getter final List<Match> matches;

    private int index = 0;

    public Rotation(List<Match> matches) {
        rotation = this;
        this.matches = matches;
    }

    public void begin() throws Exception {
        getMatch().prepare();
        getMatch().load();
        getMatch().generate();
        getMatch().open();
    }

    public Match getMatch() {
        return matches.get(index);
    }

    public Match getNextMatch() {
        return matches.get(index + 1);
    }

    public void cycle() {
        getMatch().close();

        index += 1;

        getMatch().open();
    }

}
