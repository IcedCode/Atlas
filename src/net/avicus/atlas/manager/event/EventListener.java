package net.avicus.atlas.manager.event;

import net.avicus.atlas.xml.elements.event.Damage;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import java.util.List;

public class EventListener implements Listener {

    private final EventManager manager;

    public EventListener(EventManager manager) {
        this.manager = manager;
    }

    @EventHandler
    public void onDamage(EntityDamageEvent event) {
        List<Damage> events = manager.getEvents(Damage.class);

        if (events.size() == 0)
            return;

        for (Damage damage : events) {
            if (!manager.check(damage, event.getEntity().getLocation()))
                continue;

            manager.handleActions(damage, manager.getVariables(damage));
        }
    }

}
