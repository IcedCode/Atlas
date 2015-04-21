package net.avicus.atlas.event;

import lombok.Getter;
import net.avicus.atlas.match.Match;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerSpawnEvent extends Event {

    @Getter final Player player;

    public PlayerSpawnEvent(Player player) {
        this.player = player;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
