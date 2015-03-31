package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.components.region.Circle;
import net.avicus.atlas.xml.components.region.Cuboid;
import net.avicus.atlas.xml.components.Item;
import net.avicus.atlas.xml.components.region.Cylinder;
import net.avicus.atlas.xml.components.region.Point;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public class Condition {

    @Getter
    @Attribute
    String name;

    @Getter
    @Attribute(required = false)
    String require = "one";

    @Getter
    @ElementListUnion({
            @ElementList(name="item", type=Item.class, inline = true),
            @ElementList(name="point", type=Point.class, inline = true),
            @ElementList(name="cuboid", type=Cuboid.class, inline = true),
            @ElementList(name="cylinder", type=Cylinder.class, inline = true),
            @ElementList(name="circle", type=Circle.class, inline = true)
    })
    List<Object> list;

}
