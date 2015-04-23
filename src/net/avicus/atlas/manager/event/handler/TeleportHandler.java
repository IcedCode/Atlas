package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.event.EventManager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Teleport;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class TeleportHandler extends Handler<Teleport> {

    public TeleportHandler(EventManager manager) {
        super(manager, Teleport.class);
    }

    @Override
    public void handle(Teleport action, Cancellable input) {

    }

    @Override
    public void handle(Teleport action, Player input) {
        input.teleport(action.getPosition().toLocation(manager.getMatch().getWorld()));
    }
}
