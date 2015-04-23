package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Teleport;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TeleportPlayerHandler extends Handler<Teleport, Player> {

    public TeleportPlayerHandler(Manager manager) {
        super(manager, "player", Teleport.class, Player.class);
    }

    @Override
    public void handle(Teleport event, Player handle) {
        Location location = event.getPosition().toLocation(manager.getMatch().getWorld());
        handle.teleport(location);
    }

}
