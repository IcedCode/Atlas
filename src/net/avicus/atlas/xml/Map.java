package net.avicus.atlas.xml;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Spawn;
import net.avicus.atlas.xml.data.Version;
import net.avicus.atlas.xml.elements.*;
import net.avicus.atlas.xml.elements.event.Event;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import java.util.List;

@ToString
@Root
public class Map implements Assembler {

    public void assemble() throws AssemblerException {
        for (Author author : authors)
            author.assemble(this);
        for (Team team : teams)
            team.assemble(this);
        for (Spawn spawn : spawns)
            spawn.assemble(this);
        for (ConditionSet condition : conditions)
            condition.assemble(this);
        for (Event event : events)
            event.assemble(this);
        for (Monument monument : monuments)
            monument.assemble(this);
        for (Loadout loadout : loadouts)
            loadout.assemble(this);
        assemble(this);
    }

    @Getter
    @Element
    String name;

    @Getter
    @Element
    Version version;

    @Getter
    @ElementList
    List<Author> authors;

    @Getter
    @ElementList(required = false)
    List<Team> teams;

    @Getter
    @ElementList(required = false)
    List<Spawn> spawns;

    @Getter
    @ElementList(required = false)
    List<ConditionSet> conditions;

    @Getter
    @Element
    Events events;

    @Getter
    @ElementList(required = false)
    List<Monument> monuments;

    @Getter
    @ElementList(required = false)
    List<Loadout> loadouts;

    public Loadout getLoadoutByName(String name) {
        for (Loadout loadout : loadouts)
            if (loadout.getName().equalsIgnoreCase(name))
                return loadout;
        return null;
    }

    public Team getTeamByColor(String color) {
        for (Team team : teams)
            if (team.getColor().getName().equalsIgnoreCase(color))
                return team;
        return null;
    }

    public ConditionSet getConditionByName(String name) {
        for (ConditionSet condition : conditions)
            if (condition.getName().equalsIgnoreCase(name))
                return condition;
        return null;
    }

    @Override
    public void assemble(Map map) throws AssemblerException {

    }
}
