package net.avicus.atlas.command;

import com.sk89q.minecraft.util.commands.Command;
import com.sk89q.minecraft.util.commands.CommandContext;
import com.sk89q.minecraft.util.commands.CommandException;
import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.manager.team.TeamManager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.rotation.Rotation;
import net.avicus.atlas.util.ChatUtils;
import net.avicus.atlas.xml.elements.Team;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TeamCommands {

    @Command(aliases = "join", desc = "Join a team.")
    public static void join(final CommandContext cmd, CommandSender sender) throws CommandException {
        if (!(sender instanceof Player))
            throw new CommandException(Lang.ERROR_NOT_PLAYER.translate(ChatUtils.getLocale(sender)));

        Match match = Rotation.getInstance().getMatch();

        TeamManager teams = match.getManager(TeamManager.class);

        Team from = teams.getTeam((Player) sender);
    }

}