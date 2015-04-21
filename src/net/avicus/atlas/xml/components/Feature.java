package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;

@ToString
public class Feature {

    @Getter
    @Attribute
    FeatureType type;

    @Getter
    @Attribute(required = false)
    String settings;

}
