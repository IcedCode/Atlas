package net.avicus.atlas.manager.loadout;

import net.avicus.atlas.util.MetaDataUtils;
import net.avicus.atlas.util.Task;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FeatureTask extends Task {

    @Override
    public void run() throws Exception {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (MetaDataUtils.getBoolean(player, "disable-hunger", false))
                player.setFoodLevel(20);

            // If player is spectator, no need to hide other spectators.
            if (MetaDataUtils.getBoolean(player, "spectator", false))
                continue;

            for (Player target : Bukkit.getOnlinePlayers()) {
                boolean hide = MetaDataUtils.getBoolean(target, "spectator", false);

                if (hide)
                    player.hidePlayer(target);
                else
                    player.showPlayer(target);
            }
        }
    }
}
