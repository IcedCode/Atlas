package net.avicus.atlas.manager.event;

import lombok.Getter;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.xml.elements.event.action.Action;

public abstract class Handler<A extends Action,O> {

    protected final Manager manager;
    @Getter final String var;
    @Getter final Class<A> actionType;
    @Getter final Class<O> objectType;

    public Handler(Manager manager, String var, Class<A> actionType, Class<O> objectType) {
        this.manager = manager;
        this.var = var;
        this.actionType = actionType;
        this.objectType = objectType;
    }

    public abstract void handle(A event, O handle);

}
