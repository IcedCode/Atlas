package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.data.Duration;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString
public class Effect {

    @Getter
    @Text
    String name;

    @Getter
    @Attribute(required = false)
    int amplifier = 1;

    @Getter
    @Attribute(required = false)
    Duration duration = new Duration(-1);

}
