package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Cuboid extends Region {

    @Attribute
    Position min;

    @Attribute
    Position max;

}
