package net.avicus.atlas.manager.event.handler;

import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.manager.event.Handler;
import net.avicus.atlas.xml.elements.event.action.Merge;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class MergeEventHandler extends Handler<Merge, PlayerPickupItemEvent> {

    public MergeEventHandler(Manager manager) {
        super(manager, "event", Merge.class, PlayerPickupItemEvent.class);
    }

    @Override
    public void handle(Merge merge, PlayerPickupItemEvent event) {
        Item drop = event.getItem();

        for (ItemStack item : event.getPlayer().getInventory().getContents()) {
            if (item == null || item.getType() == Material.AIR)
                continue;

            if (item.getType() != drop.getItemStack().getType())
                continue;

            item.setDurability((short) 0);
            event.setCancelled(true);
            drop.remove();
            break;
        }
    }

}
