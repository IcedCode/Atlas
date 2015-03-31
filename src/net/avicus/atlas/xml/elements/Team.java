package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.data.TeamColor;
import org.simpleframework.xml.Attribute;

@ToString
public class Team {

    @Getter
    @Attribute
    TeamColor color;

    @Getter
    @Attribute
    int max;

}
