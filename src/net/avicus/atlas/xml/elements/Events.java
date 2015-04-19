package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.elements.event.*;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.Iterator;
import java.util.List;

public class Events implements Iterable<Event> {

    @Getter
    @ElementListUnion({
            @ElementList(name = "build", type = Build.class, inline = true),
            @ElementList(name = "interact", type = Interact.class, inline = true),
            @ElementList(name = "kill", type = Kill.class, inline = true),
            @ElementList(name = "damage", type = Damage.class, inline = true),
            @ElementList(name = "move", type = Move.class, inline = true),
            @ElementList(entry = "remove-drops", type = RemoveDrops.class, inline = true)
    })
    List<Event> list;

    @Override
    public Iterator<Event> iterator() {
        return list.iterator();
    }

    @Override
    public String toString() {
        return list.toString();
    }

}
