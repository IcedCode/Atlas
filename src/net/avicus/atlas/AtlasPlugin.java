package net.avicus.atlas;

import lombok.Getter;
import net.avicus.atlas.chat.Console;
import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.rotation.Rotation;
import net.avicus.atlas.rotation.folder.LocalMap;
import net.avicus.atlas.util.yaml.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AtlasPlugin extends JavaPlugin {

    @Getter static AtlasPlugin instance;

    private Config config;

    public void onEnable() {
        instance = this;

        Console.log(Lang.CONSOLE_BOOT.with(getDescription().getVersion()));

        File configFile = new File(getDataFolder(), "config.yml");

        try {
            configFile.getParentFile().mkdirs();
            if (!configFile.exists())
                Files.copy(getResource(configFile.getName()), configFile.toPath());

            this.config = new Config(new FileInputStream(configFile));
        } catch (Exception e) {
            e.printStackTrace();
            setEnabled(false);
            return;
        }

        loadRotation();

        loadCommands();
    }

    public void onDisable() {
        Console.log(Lang.CONSOLE_SHUTDOWN.with(getDescription().getVersion()));
    }

    private void loadRotation() {
        List<Match> matches = new ArrayList<Match>();

        for (String name : config.getStringList("rotation"))
            matches.add(new Match(new LocalMap(new File("maps", name))));

        Rotation rotation = new Rotation(matches);
        try {
            rotation.begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCommands() {
        // todo later.
    }

}
