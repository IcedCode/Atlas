package net.avicus.atlas.event;

import lombok.Getter;
import net.avicus.atlas.manager.event.Variables;
import net.avicus.atlas.xml.elements.event.GameEvent;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class VariablesRequestEvent extends Event {

    @Getter final Variables variables;

    public VariablesRequestEvent(Variables variables) {
        this.variables = variables;
    }

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public HandlerList getHandlers() {
        return handlers;
    }

}
