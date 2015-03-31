package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Circle extends Region {

    @Attribute
    Position center;

    @Attribute
    int radius;

}
