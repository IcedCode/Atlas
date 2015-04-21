package net.avicus.atlas.match;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.event.MatchCloseEvent;
import net.avicus.atlas.event.MatchOpenEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.game.GameManager;
import net.avicus.atlas.manager.spawn.SpawnManager;
import net.avicus.atlas.manager.state.StateManager;
import net.avicus.atlas.manager.team.TeamManager;
import net.avicus.atlas.rotation.folder.MapFolder;
import net.avicus.atlas.util.EventUtils;
import net.avicus.atlas.xml.Map;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@ToString
public class Match {

    private static int LAST_ID = 0;

    @Getter final int id;
    @Getter final File folder;
    @Getter final MapFolder packet;
    @Getter final List<Manager> managers = new ArrayList<Manager>();

    private Map map;
    @Getter World world;

    public Match(MapFolder packet) {
        this.packet = packet;
        this.id = LAST_ID += 1;
        this.folder = new File("match-" + id);
        managers();
    }

    private void managers() {
        managers.add(new GameManager(this));
        managers.add(new StateManager(this));
        managers.add(new TeamManager(this));
        managers.add(new SpawnManager(this));
    }

    public <T extends Manager> T getManager(Class<T> type) {
        for (Manager manager : managers)
            if (manager.getClass() == type)
                return (T) manager;
        throw new RuntimeException("Manager not found: " + type.getSimpleName());
    }

    public void prepare() throws Exception {
        packet.prepare();
    }

    public void load() throws Exception {
        this.map = Map.parse(packet.getConfig());
        packet.move(folder);
    }

    public void generate() throws Exception {
        WorldCreator creator = new WorldCreator(folder.getName());
        world = creator.createWorld();
    }

    public void open() {
        for (Manager manager : managers)
            EventUtils.register(manager);

        EventUtils.call(new MatchOpenEvent(this));
    }

    public void close() {
        EventUtils.call(new MatchCloseEvent(this));

        for (Manager manager : managers)
            EventUtils.unregister(manager);
    }

    public Map getMap() {
        if (map == null)
            throw new RuntimeException("Map not loaded in match yet!");
        return map;
    }

}
