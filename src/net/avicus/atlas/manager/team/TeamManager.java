package net.avicus.atlas.manager.team;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.MetaDataUtils;
import net.avicus.atlas.xml.elements.Team;
import org.bukkit.entity.Player;

public class TeamManager extends Manager {

    public TeamManager(Match match) {
        super(match);
    }

    public Team getSpectators() {
        return match.getMap().getTeamByColor("aqua");
    }

    public Team getTeam(Player player) {
        return match.getMap().getTeamByColor(MetaDataUtils.getString(player, "team", null));
    }

    public void add(Team team, Player player) {
        MetaDataUtils.set(player, "team", team.getColor().toString());
    }

    public void remove(Team team, Player player) {
        MetaDataUtils.unset(player, team.getColor().toString());
    }

}
