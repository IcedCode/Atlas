package net.avicus.atlas.util;

import net.avicus.atlas.AtlasPlugin;
import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

public class EventUtils {

    public static void register(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, AtlasPlugin.getInstance());
    }

    public static void unregister(Listener listener) {
        HandlerList.unregisterAll(listener);
    }

    public static <T extends Event> T call(T event) {
        Bukkit.getPluginManager().callEvent(event);
        return event;
    }

}
