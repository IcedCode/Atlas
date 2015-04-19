package net.avicus.atlas.xml.components;

import lombok.Getter;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.elements.RegionSet;
import net.avicus.atlas.xml.elements.Team;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Spawn implements Assembler {

    @Getter
    @Attribute(name = "team")
    String teamName;

    @Getter
    @Element
    RegionSet regions;

    @Getter
    Team team;

    @Override
    public void assemble(Map map) throws AssemblerException {
        team = map.getTeamByColor(teamName);
        if (team == null)
            throw new AssemblerException("Unknown team: \"" + teamName + "\"");
        regions.assemble(map);
    }
}
