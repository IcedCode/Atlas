package net.avicus.atlas.event;

import lombok.Getter;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.xml.elements.State;
import org.bukkit.event.HandlerList;

public class MatchStateChangeEvent extends MatchEvent {

    @Getter State from;
    @Getter State to;

    public MatchStateChangeEvent(Match match, State from, State to) {
        super(match);
        this.from = from;
        this.to = to;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
