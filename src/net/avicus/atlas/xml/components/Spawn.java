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
    @Attribute(name = "team", required = false)
    String teamColor = "aqua";

    @Getter
    @Attribute(required = false)
    float yaw = 0;

    @Getter
    @Attribute(required = false)
    float pitch = 0;

    @Getter
    @Element
    RegionSet regions;

    @Getter
    Team team;

    @Override
    public void assemble(Map map) throws AssemblerException {
        team = map.getTeamByColor(teamColor);
        if (team == null)
            throw new AssemblerException("Unknown team: \"" + teamColor + "\"");
        regions.assemble(map);
    }
}
