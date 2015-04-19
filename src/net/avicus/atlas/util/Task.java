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

    @Getter BukkitRunnable task;
    @Getter protected boolean running;

    public void now() {
        task = newTask();
        task.runTask(plugin);
    }

    public void nowAsync() {
        task = newTask();
        task.runTaskAsynchronously(plugin);
    }

    public void later(int delay) {
        task = newTask();
        task.runTaskLater(plugin, delay);
    }

    public void laterAsync(int delay) {
        task = newTask();
        task.runTaskLaterAsynchronously(plugin, delay);
    }

    public void repeat(int delay, int ticks) {
        task = newTask();
        task.runTaskTimer(plugin, delay, ticks);
    }

    public void repeatAsync(int delay, int ticks) {
        task = newTask();
        task.runTaskTimerAsynchronously(plugin, delay, ticks);
    }

    public void cancel() {
        if (task == null)
            return;

        task.cancel();
        running = false;
    }

    private BukkitRunnable newTask() {
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