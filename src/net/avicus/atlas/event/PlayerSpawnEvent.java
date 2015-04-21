package net.avicus.atlas.event;

import lombok.Getter;
import net.avicus.atlas.xml.components.Spawn;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerSpawnEvent extends Event {

    @Getter final Player player;
    @Getter final Spawn spawn;

    public PlayerSpawnEvent(Player player, Spawn spawn) {
        this.player = player;
        this.spawn = spawn;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
