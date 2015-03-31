package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString
public class Item {

    @Getter
    @Text
    String item;

    @Getter
    @Attribute(required = false)
    String slot = "-1";

    @Getter
    @Attribute(required = false)
    int count = 1;

    @Getter
    @Attribute(required = false)
    String enchantment;

}
