package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.manager.loadout.LoadoutManager;
import net.avicus.atlas.xml.elements.event.action.ApplyLoadout;
import org.bukkit.entity.Player;

public class ApplyLoadoutHandler extends Handler<ApplyLoadout, Player> {

    public ApplyLoadoutHandler(Manager manager) {
        super(manager, "player", ApplyLoadout.class, Player.class);
    }

    @Override
    public void handle(ApplyLoadout event, Player handle) {
        manager.getMatch().getManager(LoadoutManager.class).give(event.getLoadout(), handle);
    }

}
