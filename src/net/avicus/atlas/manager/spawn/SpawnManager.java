package net.avicus.atlas.manager.spawn;

import net.avicus.atlas.event.PlayerSpawnEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.EventUtils;
import net.avicus.atlas.xml.components.Spawn;
import net.avicus.atlas.xml.components.region.Region;
import net.avicus.atlas.xml.data.Position;
import net.avicus.atlas.xml.elements.Team;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;

public class SpawnManager extends Manager {

    public SpawnManager(Match match) {
        super(match);
    }

    public void spawn(Team team, Player player) {
        Spawn spawn = getSpawn(team);
        player.teleport(getLocation(spawn));

        PlayerSpawnEvent call = EventUtils.call(new PlayerSpawnEvent(player));
    }

    public Spawn getSpawn(Team team) {
        for (Spawn spawn : match.getMap().getSpawns())
            if (spawn.getTeam() == team)
                return spawn;
        return null;
    }

    public Region getRegion(Spawn spawn) {
        List<Region> regions = spawn.getRegions().getList();
        return regions.get(new Random().nextInt(regions.size()));
    }

    public Location getLocation(Spawn spawn) {
        Region region = getRegion(spawn);
        Position random = region.getRandomPosition();
        return new Location(match.getWorld(), random.getX(), random.getY(), random.getZ(), spawn.getYaw(), spawn.getPitch());
    }

}
