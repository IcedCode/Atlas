package net.avicus.atlas.xml.components;

import lombok.Getter;
import org.simpleframework.xml.Attribute;

public class Feature {

    @Getter
    @Attribute
    FeatureType type;

    @Getter
    @Attribute(required = false)
    String settings;

}
