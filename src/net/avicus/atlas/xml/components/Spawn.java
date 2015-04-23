package net.avicus.atlas.xml.components;

import lombok.Getter;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.elements.Loadout;
import net.avicus.atlas.xml.elements.RegionSet;
import net.avicus.atlas.xml.elements.Team;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

public class Spawn implements Assembler {

    @Getter
    @Attribute
    String id;

    @Getter
    @Attribute(name = "team", required = false)
    String teamId = "spectators";

    @Getter
    @Attribute(name = "loadout", required = false)
    String loadoutName;

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

    @Getter
    Loadout loadout;

    @Override
    public void assemble(Map map) throws AssemblerException {
        team = map.getTeamById(teamId);
        if (team == null)
            throw new AssemblerException("Unknown team: \"" + teamId + "\"");
        loadout = map.getLoadoutById(loadoutName);
        regions.assemble(map);
    }
}
