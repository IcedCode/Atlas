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
        for (GameEvent event : events)
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
    @ElementList
    List<State> states;

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
            @ElementList(entry = "pickup-item", type = PickupItem.class, inline = true),
            @ElementList(entry = "drop-item", type = DropItem.class, inline = true)
    })
    List<GameEvent> events;

    @Getter
    @ElementList(required = false)
    List<Monument> monuments;

    @Getter
    @ElementList(required = false)
    List<Loadout> loadouts;

    public Loadout getLoadoutById(String id) {
        for (Loadout loadout : loadouts)
            if (loadout.getId().equalsIgnoreCase(id))
                return loadout;
        return null;
    }

    public Team getTeamById(String id) {
        for (Team team : teams)
            if (team.getId().equalsIgnoreCase(id))
                return team;
        return null;
    }

    public ConditionSet getConditionById(String id) {
        for (ConditionSet condition : conditions)
            if (condition.getId().equalsIgnoreCase(id))
                return condition;
        return null;
    }

    public Spawn getSpawnById(String id) {
        for (Spawn spawn : spawns)
            if (spawn.getId().equalsIgnoreCase(id))
                return spawn;
        return null;
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (getTeamById("spectators") == null)
            throw new AssemblerException("Spectators team must be defined!");
    }
}
