package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;

@ToString
public class State {

    @Getter
    @Attribute
    String id;

}
