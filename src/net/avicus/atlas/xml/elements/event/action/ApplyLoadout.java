package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString
public class ApplyLoadout {

    @Getter
    @Attribute
    boolean clear;

    @Getter
    @Text
    String name;

}
