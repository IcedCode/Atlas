package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;

@ToString
public abstract class Action {

    @Getter
    @Attribute(required = false)
    int priority;

}
