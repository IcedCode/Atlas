package net.avicus.atlas.util;

import net.avicus.atlas.chat.locale.Locale;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ChatUtils {

    public static Locale getLocale(CommandSender sender) {
        String name = sender instanceof Player ? ((Player) sender).spigot().getLocale() : "en";
        return Locale.getByName(name);
    }

}
