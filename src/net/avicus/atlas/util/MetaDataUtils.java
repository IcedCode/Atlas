package net.avicus.atlas.util;

import net.avicus.atlas.AtlasPlugin;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class MetaDataUtils {

    public static void set(Player player, String key, Object value) {
        player.setMetadata(key, new FixedMetadataValue(AtlasPlugin.getInstance(), value));
    }

}
