package net.avicus.atlas.match;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.Atlas;
import net.avicus.atlas.rotation.MapPacket;
import net.avicus.atlas.xml.Map;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.io.File;

@ToString
public class Match {

    private static int LAST_ID = 0;

    @Getter final int id;
    @Getter final File folder;
    @Getter final MapPacket packet;

    private Map map;
    @Getter World world;

    public Match(MapPacket packet) {
        this.packet = packet;
        this.id = LAST_ID += 1;
        this.folder = new File("match-" + id);
    }

    public void prepare() throws Exception {
        packet.prepare();
    }

    public void load() throws Exception {
        this.map = Atlas.parse(packet.getConfig());
        packet.move(folder);
    }

    public void generate() throws Exception {
        WorldCreator creator = new WorldCreator(folder.getName());
        world = creator.createWorld();
    }

    public Map getMap() {
        if (map == null)
            throw new RuntimeException("Map not loaded in match yet!");
        return map;
    }

    public void start() {

    }

    public void end() {
        
    }

}
