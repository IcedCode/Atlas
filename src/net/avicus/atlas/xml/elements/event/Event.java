package net.avicus.atlas.xml.elements.event;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.elements.event.action.*;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public abstract class Event {

    @Getter
    @Attribute(required = false)
    String condition;

    @Getter
    @ElementListUnion({
            @ElementList(entry = "message", type=Message.class, inline = true),
            @ElementList(entry = "teleport", type=Teleport.class, inline = true),
            @ElementList(entry = "apply-loadout", type=ApplyLoadout.class, inline = true),
            @ElementList(entry = "cancel", type=Cancel.class, inline = true),
            @ElementList(entry = "push", type=Push.class, inline = true)
    })
    List<Action> actions;

}
