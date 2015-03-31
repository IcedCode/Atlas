package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString
public class Effect {

    @Getter
    @Text
    String name;

    @Getter
    @Attribute
    int amplifier;

    @Getter
    @Attribute
    String duration;

}
