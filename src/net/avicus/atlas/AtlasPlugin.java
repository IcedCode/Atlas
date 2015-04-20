package net.avicus.atlas;

import com.sk89q.bukkit.util.CommandsManagerRegistration;
import com.sk89q.minecraft.util.commands.*;
import lombok.Getter;
import net.avicus.atlas.chat.Console;
import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.command.AtlasCommand;
import net.avicus.atlas.command.ManagerCommands;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.manager.LocalMap;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.util.ChatUtils;
import net.avicus.atlas.util.yaml.Config;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class AtlasPlugin extends JavaPlugin {

    @Getter static AtlasPlugin instance;

    private CommandsManager<CommandSender> commands;
    private Config config;

    public void onEnable() {
        instance = this;

        Console.log(Lang.ATLAS_BOOT.with(getDescription().getVersion()));

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
        Console.log(Lang.ATLAS_SHUTDOWN.with(getDescription().getVersion()));
    }

    private void loadRotation() {
        List<Match> matches = new ArrayList<Match>();

        for (String name : config.getStringList("rotation"))
            matches.add(new Match(new LocalMap(new File("maps", name))));

        Manager manager = new Manager(matches);
        try {
            manager.begin();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadCommands() {
        commands = new CommandsManager<CommandSender>() {
            @Override
            public boolean hasPermission(CommandSender sender, String perm) {
                return sender instanceof ConsoleCommandSender || sender.hasPermission(perm);
            }
        };
        CommandsManagerRegistration register = new CommandsManagerRegistration(this, commands);

        register.register(AtlasCommand.class);
        register.register(ManagerCommands.class);
    }

    @Override
     public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        try {
            this.commands.execute(cmd.getName(), args, sender, sender);
        } catch (CommandPermissionsException e) {
            sender.sendMessage(ChatColor.RED + Lang.ERROR_NO_PERMISSION.translate(ChatUtils.getLocale(sender)));
        } catch (MissingNestedCommandException e) {
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (CommandUsageException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
            sender.sendMessage(ChatColor.RED + e.getUsage());
        } catch (WrappedCommandException e) {
            sender.sendMessage(ChatColor.RED + Lang.ERROR_ERROR_OCCURRED.translate(ChatUtils.getLocale(sender)));
            e.printStackTrace();
        } catch (CommandException e) {
            sender.sendMessage(ChatColor.RED + e.getMessage());
        }
        return true;
    }

}
