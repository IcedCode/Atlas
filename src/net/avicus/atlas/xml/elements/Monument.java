package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

@ToString
public class Monument implements Assembler {

    @Getter
    @Attribute
    String name;

    @Getter
    @Attribute
    String owner;

    @Getter
    @Element
    RegionSet region;

    @Getter
    Team team;

    @Override
    public void assemble(Map map) throws AssemblerException {
        team = map.getTeamByColor(owner);
        if (team == null)
            throw new AssemblerException("Unknown team: \"" + owner + "\"");
    }
}
