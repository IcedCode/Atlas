package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

@ToString
public class Monument {

    @Getter
    @Attribute
    String name;

    @Getter
    @Attribute
    String owner;

    @Getter
    @Element
    RegionSet region;

}
