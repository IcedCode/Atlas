package net.avicus.atlas.manager.event;

import net.avicus.atlas.xml.elements.event.Build;
import net.avicus.atlas.xml.elements.event.Damage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class EventListener implements Listener {

    private final EventManager manager;

    public EventListener(EventManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void damage(EntityDamageEvent event) {
        List<Damage> events = manager.getEvents(Damage.class);

        if (events.size() == 0)
            return;

        Variables vars = manager.getVariables();

        vars.add("event", event);
        vars.add("entity", event.getEntity());
        if (event.getEntity() instanceof Player)
            vars.add("player", event.getEntity());

        for (Damage call : events) {
            if (!manager.check(call, event.getEntity().getLocation()))
                continue;

            manager.handleActions(call, vars);
        }
    }

    @EventHandler
    public void build(BlockPlaceEvent event) {
        List<Build> events = manager.getEvents(Build.class);

        if (events.size() == 0)
            return;

        Variables vars = manager.getVariables();

        vars.add("event", event);
        vars.add("player", event.getPlayer());

        for (Build call : events) {
            manager.handleActions(call, vars);
        }
    }

}
