package net.avicus.atlas.manager.game;

import net.avicus.atlas.event.MatchOpenEvent;
import net.avicus.atlas.event.MatchStateChangeEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.spawn.SpawnManager;
import net.avicus.atlas.manager.state.StateManager;
import net.avicus.atlas.manager.team.TeamManager;
import net.avicus.atlas.match.Match;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

public class GameManager extends Manager {

    public GameManager(Match match) {
        super(match);
    }

    public void spawnSpectator(Player player) {
        TeamManager teams = match.getManager(TeamManager.class);
        teams.add(teams.getSpectators(), player);

        SpawnManager spawns = match.getManager(SpawnManager.class);
        spawns.spawn(teams.getSpectators(), player);
    }

    @EventHandler
    public void onMatchOpen(MatchOpenEvent event) {
        for (Player player : Bukkit.getOnlinePlayers())
            spawnSpectator(player);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        spawnSpectator(event.getPlayer());

        System.out.println(match.getManager(StateManager.class).getTime());
    }

    @EventHandler
    public void onMatchStateChange(MatchStateChangeEvent event) {
        System.out.println(event.getFrom() + " to " + event.getTo());
    }

}
