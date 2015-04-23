package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.event.EventManager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Cancel;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public class CancelHandler extends Handler<Cancel> {

    public CancelHandler(EventManager manager) {
        super(manager, Cancel.class);
    }

    @Override
    public void handle(Cancel action, Cancellable input) {
        input.setCancelled(action.isCancel());
    }

    @Override
    public void handle(Cancel action, Player input) {

    }
}
