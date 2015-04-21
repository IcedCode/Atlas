package net.avicus.atlas.event;

import net.avicus.atlas.match.Match;
import org.bukkit.event.HandlerList;

public class MatchCloseEvent extends MatchEvent {

    public MatchCloseEvent(Match match) {
        super(match);
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
