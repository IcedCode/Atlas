package net.avicus.atlas.util;

import net.avicus.atlas.AtlasPlugin;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

public class MetaDataUtils {

    public static void set(Player player, String key, Object value) {
        player.setMetadata(key, new FixedMetadataValue(AtlasPlugin.getInstance(), value));
    }

    public static String getString(Player player, String key, String def) {
        if (!player.hasMetadata(key))
            return def;
        return player.getMetadata(key).get(0).asString();
    }

    public static boolean getBoolean(Player player, String key, boolean def) {
        if (!player.hasMetadata(key))
            return def;
        return player.getMetadata(key).get(0).asBoolean();
    }

    public static void unset(Player player, String key) {
        player.removeMetadata(key, AtlasPlugin.getInstance());
    }

}
