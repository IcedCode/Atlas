package net.avicus.atlas.manager.loadout;

import net.avicus.atlas.event.PlayerSpawnEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.MetaDataUtils;
import net.avicus.atlas.xml.components.LoadoutFeature;
import net.avicus.atlas.xml.elements.Loadout;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

public class LoadoutManager extends Manager {

    public LoadoutManager(Match match) {
        super(match);
    }

    public void give(Loadout loadout, Player player) {
        player.setFlying(false);
        player.setAllowFlight(false);
        MetaDataUtils.set(player, "hidden", false);

        for (LoadoutFeature feature : loadout.getFeatures()) {
            if (feature.getType().equalsIgnoreCase("fly")) {
                player.setAllowFlight(true);
                player.setFlying(true);
            }
            else if (feature.getType().equalsIgnoreCase("hidden")) {
                MetaDataUtils.set(player, "hidden", true);
            }
        }
    }

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnEvent event) {
        Loadout loadout = match.getMap().getLoadoutByName("spectators");
        give(loadout, event.getPlayer());
    }

}
