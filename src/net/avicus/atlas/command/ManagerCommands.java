package net.avicus.atlas.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import net.avicus.atlas.manager.Manager;
import org.bukkit.command.CommandSender;

public class ManagerCommands {

    @Command(aliases = "start", desc = "Start an upcoming match.")
    public static void atlas(final CommandContext cmd, CommandSender sender) throws CommandUsageException {
        Manager manager = Manager.getManager();
        manager.start();
    }

}
