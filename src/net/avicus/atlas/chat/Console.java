package net.avicus.atlas.chat;

import net.avicus.atlas.chat.locale.LocalizedMessage;
import net.avicus.atlas.util.ChatUtils;
import org.bukkit.Bukkit;

public class Console {

    public static void log(LocalizedMessage string) {
        Bukkit.getConsoleSender().sendMessage(string.translate(ChatUtils.getLocale(Bukkit.getConsoleSender())));
    }

    public static void debug(String message) {
        Bukkit.getConsoleSender().sendMessage(message);
    }

}
