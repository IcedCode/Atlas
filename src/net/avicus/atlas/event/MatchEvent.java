package net.avicus.atlas.event;

import lombok.Getter;
import net.avicus.atlas.match.Match;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MatchEvent extends Event {

    @Getter final Match match;

    public MatchEvent(Match match) {
        this.match = match;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
