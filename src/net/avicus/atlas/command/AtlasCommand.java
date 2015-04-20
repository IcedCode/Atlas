package net.avicus.atlas.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandUsageException;
import net.avicus.atlas.AtlasPlugin;
import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.util.ChatUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class AtlasCommand {

    @Command(aliases = "atlas", flags = "v", desc = "Various commands for Atlas.")
    public static void atlas(final CommandContext cmd, CommandSender sender) throws CommandUsageException {
        if (cmd.hasFlag('v'))
            sender.sendMessage(ChatColor.GOLD + Lang.UI_VERSION.with(AtlasPlugin.getInstance().getDescription().getVersion()).translate(ChatUtils.getLocale(sender)));
        else
            throw new CommandUsageException(Lang.ERROR_INVALID_ARGUMENTS.translate(ChatUtils.getLocale(sender)), "/atlas (-v)");
    }

}
