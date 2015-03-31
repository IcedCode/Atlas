package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.components.Effect;
import net.avicus.atlas.xml.components.Item;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public class Loadout {

    @Getter
    @Attribute
    String name;

    @Getter
    @ElementListUnion({
            @ElementList(name="item", type=Item.class),
            @ElementList(name="effect", type=Effect.class)
    })
    List<Object> regions;

}
