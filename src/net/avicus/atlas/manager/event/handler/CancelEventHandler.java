package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.event.EventManager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Cancel;
import org.bukkit.event.Cancellable;

public class CancelEventHandler extends Handler<Cancel, Cancellable> {

    public CancelEventHandler(EventManager manager) {
        super(manager, "event", Cancel.class, Cancellable.class);
    }

    @Override
    public void handle(Cancel event, Cancellable handle) {
        handle.setCancelled(event.isCancel());
    }

}
