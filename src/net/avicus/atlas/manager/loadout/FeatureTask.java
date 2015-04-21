package net.avicus.atlas.manager.loadout;

import net.avicus.atlas.chat.Console;
import net.avicus.atlas.util.MetaDataUtils;
import net.avicus.atlas.util.Task;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class FeatureTask extends Task {

    @Override
    public void run() throws Exception {
        Console.debug("Running feature task...");
        for (Player player : Bukkit.getOnlinePlayers()) {
            // If player is spectator, no need to hide other spectators.
            if (MetaDataUtils.getBoolean(player, "spectator", false))
                return;

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
