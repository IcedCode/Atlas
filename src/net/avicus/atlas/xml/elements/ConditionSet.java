package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.components.Item;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public class ConditionSet {

    @Getter
    @Attribute
    String name;

    @Getter
    @Attribute(required = false)
    String require = "one";

    @Getter
    @ElementListUnion({
            @ElementList(name="item", type=Item.class, inline = true),
            @ElementList(entry="region", type=RegionSet.class, inline = true)
    })
    List<Condition> list;

}
