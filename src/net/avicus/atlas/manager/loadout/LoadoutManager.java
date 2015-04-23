package net.avicus.atlas.manager.loadout;

import net.avicus.atlas.event.MatchCloseEvent;
import net.avicus.atlas.event.MatchOpenEvent;
import net.avicus.atlas.event.PlayerSpawnEvent;
import net.avicus.atlas.manager.Manager;
import net.avicus.atlas.match.Match;
import net.avicus.atlas.util.MetaDataUtils;
import net.avicus.atlas.xml.components.Enchant;
import net.avicus.atlas.xml.components.FeatureType;
import net.avicus.atlas.xml.components.Item;
import net.avicus.atlas.xml.elements.Loadout;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class LoadoutManager extends Manager {

    private FeatureTask listener = new FeatureTask();

    public LoadoutManager(Match match) {
        super(match);
    }

    public Loadout getDefault() {
        Loadout def = match.getMap().getLoadoutById("default");
        if (def == null)
            return new Loadout();
        return def;
    }

    public void give(Loadout loadout, Player player) {
        boolean fly = loadout.hasFeature(FeatureType.FLY);
        player.setAllowFlight(fly);
        player.setFlying(fly);

        boolean spectator = loadout.hasFeature(FeatureType.SPECTATOR);
        MetaDataUtils.set(player, "spectator", spectator);

        boolean disableHunger = loadout.hasFeature(FeatureType.DISABLE_HUNGER);
        MetaDataUtils.set(player, "disable-hunger", disableHunger);

        // Items
        for (Item item : loadout.getItems()) {
            ItemStack stack = new ItemStack(item.getMaterial(), item.getCount(), item.getData());
            ItemMeta meta = stack.getItemMeta();

            if (item.getName() != null)
                meta.setDisplayName(item.getName());

            if (item.getLore() != null)
                meta.setLore(Arrays.asList(item.getLore().split("\\n")));

            if (item.getEnchantments() != null)
                for (Enchant enchant : item.getEnchantments())
                    stack.addUnsafeEnchantment(enchant.getEnchantment(), enchant.getLevel());

            if (item.getSlot().getValue() >= 100) {
                ItemStack[] armor = player.getInventory().getArmorContents();
                armor[item.getSlot().getValue() - 100] = stack;
                player.getInventory().setArmorContents(armor);
            }
            else {
                player.getInventory().setItem(item.getSlot().getValue(), stack);
            }
        }
    }

    @EventHandler
    public void onPlayerSpawn(PlayerSpawnEvent event) {
        try {

            Loadout loadout = event.getSpawn().getLoadout();
            if (loadout == null)
                loadout = getDefault();
            give(loadout, event.getPlayer());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @EventHandler
    public void onMatchOpen(MatchOpenEvent event) {
        listener.repeat(0, 20);
    }

    @EventHandler
    public void onMatchClose(MatchCloseEvent event) {
        listener.cancel();
    }

}
