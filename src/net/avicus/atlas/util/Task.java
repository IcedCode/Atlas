package net.avicus.atlas.util;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public abstract class Task {

    private static Plugin plugin;

    static {
        plugin = Bukkit.getPluginManager().getPlugins()[0];
    }

    @Getter BukkitRunnable runnable;
    @Getter protected boolean running;

    public void now() {
        runnable = newRunnable();
        runnable.runTask(plugin);
    }

    public void nowAsync() {
        runnable = newRunnable();
        runnable.runTaskAsynchronously(plugin);
    }

    public void later(int delay) {
        runnable = newRunnable();
        runnable.runTaskLater(plugin, delay);
    }

    public void laterAsync(int delay) {
        runnable = newRunnable();
        runnable.runTaskLaterAsynchronously(plugin, delay);
    }

    public void repeat(int delay, int ticks) {
        runnable = newRunnable();
        runnable.runTaskTimer(plugin, delay, ticks);
    }

    public void repeatAsync(int delay, int ticks) {
        runnable = newRunnable();
        runnable.runTaskTimerAsynchronously(plugin, delay, ticks);
    }

    public void cancel() {
        if (runnable == null)
            return;

        runnable.cancel();
        running = false;
    }

    private BukkitRunnable newRunnable() {
        return new BukkitRunnable() {
            @Override
            public void run() {
                running = true;
                try {
                    Task.this.run();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                running = false;
            }
        };
    }

    public abstract void run() throws Exception;
}