package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.components.region.*;
import org.simpleframework.xml.*;

import java.util.List;

@ToString
public class Monument {

    @Getter
    @Attribute
    String name;

    @Getter
    @Attribute
    String owner;

    @Getter
    @ElementListUnion({
            @ElementList(name="point", type=Point.class, inline = true),
            @ElementList(name="cuboid", type=Cuboid.class, inline = true),
            @ElementList(name="cylinder", type=Cylinder.class, inline = true),
            @ElementList(name="circle", type=Circle.class, inline = true)
    })
    List<Region> regions;

}
