package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.assembler.Assembler;
import org.simpleframework.xml.Attribute;

@ToString
public abstract class Action implements Assembler {

    @Getter
    @Attribute(required = false)
    int priority;

}
