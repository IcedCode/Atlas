package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import org.simpleframework.xml.Attribute;

import java.util.UUID;

@ToString
public class Author implements Assembler {

    @Getter
    @Attribute
    UUID uuid;

    @Getter
    @Attribute
    String role;

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (role.length() > 50)
            throw new AssemblerException("Author role cannot exceed 50 characters");
    }
}
