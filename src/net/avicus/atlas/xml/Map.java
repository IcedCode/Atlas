package net.avicus.atlas.xml;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.Atlas;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Spawn;
import net.avicus.atlas.xml.data.Version;
import net.avicus.atlas.xml.elements.*;
import net.avicus.atlas.xml.elements.event.*;
import org.simpleframework.xml.*;

import java.io.InputStream;
import java.util.List;

@ToString
@Root
public class Map implements Assembler {

    public static Map parse(InputStream input) throws Exception {
        Map map = Atlas.getSerializer().read(Map.class, input);
        map.assemble();
        return map;
    }

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
    @Path(value = "events")
    @ElementListUnion({
            @ElementList(name = "build", type = Build.class, inline = true),
            @ElementList(name = "interact", type = Interact.class, inline = true),
            @ElementList(name = "kill", type = Kill.class, inline = true),
            @ElementList(name = "damage", type = Damage.class, inline = true),
            @ElementList(name = "move", type = Move.class, inline = true),
            @ElementList(entry = "remove-drops", type = RemoveDrops.class, inline = true)
    })
    List<Event> events;

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
