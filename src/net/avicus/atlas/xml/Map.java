package net.avicus.atlas.xml;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.data.Version;
import net.avicus.atlas.xml.elements.event.*;
import net.avicus.atlas.xml.elements.*;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Root;

import java.util.List;

@ToString
@Root
public class Map {

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
    List<ConditionSet> conditions;

    @Getter
    @ElementListUnion({
            @ElementList(name = "build", type = Build.class, required = false),
            @ElementList(name = "interact", type = Interact.class, required = false),
            @ElementList(name = "kill", type = Kill.class, required = false),
            @ElementList(name = "damage", type = Damage.class, required = false),
            @ElementList(name = "move", type = Move.class, required = false),
            @ElementList(entry = "remove-drops", type = RemoveDrops.class, required = false)
    })
    List<Event> events;

    @Getter
    @ElementList(required = false)
    List<Monument> monuments;

    @Getter
    @ElementList(required = false)
    List<Loadout> loadouts;

}
