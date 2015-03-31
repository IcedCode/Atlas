package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Attribute;

import java.util.UUID;

@ToString
public class Author {

    @Getter
    @Attribute
    UUID uuid;

    @Getter
    @Attribute
    String role;

}
