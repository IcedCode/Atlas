package net.avicus.atlas.xml.components;

import lombok.Getter;
import org.bukkit.enchantments.Enchantment;

public class Enchant {

    @Getter final Enchantment enchantment;
    @Getter final int level;

    public Enchant(Enchantment enchantment, int level) {
        this.enchantment = enchantment;
        this.level = level;
    }

}
