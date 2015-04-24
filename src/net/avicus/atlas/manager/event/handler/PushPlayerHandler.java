package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Push;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class PushPlayerHandler extends Handler<Push, Player> {

    public PushPlayerHandler(Manager manager) {
        super(manager, "player", Push.class, Player.class);
    }

    @Override
    public void handle(Push event, Player handle) {
        Vector v = handle.getLocation().getDirection();
        v.multiply(event.getVelocity());
        v.setY(event.getVertical());
        handle.setVelocity(v);
    }

}
