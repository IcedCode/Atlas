package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.TeamColor;
import org.simpleframework.xml.Attribute;

@ToString
public class Team implements Assembler {

    @Getter
    @Attribute
    String id;

    @Getter
    @Attribute
    TeamColor color;

    @Getter
    @Attribute
    int max;

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (max <= 0)
            throw new AssemblerException("Team max must be greater than 0");
    }
}
