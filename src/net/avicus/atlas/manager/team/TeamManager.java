package net.avicus.atlas.manager.team;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.xml.elements.Team;
import org.bukkit.entity.Player;

public class TeamManager extends Manager {

    public TeamManager(Match match) {
        super(match);
    }

    public Team getSpectators() {
        return match.getMap().getTeamByColor("aqua");
    }

    public void add(Team team, Player player) {

    }

    public void remove(Team team, Player player) {

    }

}
