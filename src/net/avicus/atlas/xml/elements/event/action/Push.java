package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;

@ToString
public class Push extends Action {

    @Getter
    @Attribute
    double velocity;

    @Getter
    @Attribute
    double vertical;

}
