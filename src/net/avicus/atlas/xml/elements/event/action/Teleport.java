package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Teleport {

    @Getter
    @Attribute
    Position location;

}
