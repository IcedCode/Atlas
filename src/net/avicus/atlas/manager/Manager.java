package net.avicus.atlas.manager;

import lombok.Getter;
import net.avicus.atlas.match.Match;
import org.bukkit.event.Listener;

/**
 * Manages the managers that manage the map.
 */
public abstract class Manager implements Listener {

    @Getter protected Match match;

    public Manager(Match match) {
        this.match = match;
    }

}
