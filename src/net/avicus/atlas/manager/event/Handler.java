package net.avicus.atlas.manager.event;

import lombok.Getter;
import net.avicus.atlas.xml.elements.event.action.Action;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;

public abstract class Handler<A extends Action> {

    protected final EventManager manager;
    @Getter Class<A> type;

    public Handler(EventManager manager, Class<A> type) {
        this.manager = manager;
        this.type = type;
    }

    public abstract void handle(A action, Cancellable input);

    public abstract void handle(A action, Player input);

}
