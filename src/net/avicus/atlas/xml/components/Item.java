package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.util.ChatUtils;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.ItemSlot;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import java.util.ArrayList;
import java.util.List;

@ToString
public class Item implements Condition {

    @Getter
    @Text
    String materialName;

    @Getter
    @Attribute(required = false)
    ItemSlot slot = new ItemSlot(0);

    @Getter
    @Attribute(required = false)
    int count = 1;

    @Getter
    @Attribute(name = "enchantment", required = false)
    String enchantmentRaw;

    @Getter
    @Attribute(required = false)
    String name;

    @Getter
    @Attribute(required = false)
    String lore;

    @Getter
    @Attribute(required = false)
    short data;

    @Getter
    Material material;

    @Getter
    List<Enchant> enchantments = null;

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (count <= 0)
            throw new AssemblerException("Item count must be greater than 0, but is set to " + count);


        if (slot.getValue() < 0 || (slot.getValue() > 36 && (slot.getValue() < 100 || slot.getValue() > 103)))
            throw new AssemblerException("Item slot \"" + slot + "\" is invalid.");

        material = Material.valueOf(materialName.replace(" ", "_").toUpperCase());
        name = ChatUtils.addColors(name);
        lore = ChatUtils.addColors(lore);

        if (enchantmentRaw != null) {
            enchantments = new ArrayList<Enchant>();
            for (String enchant : enchantmentRaw.split(";")) {
                String[] parts = enchant.split(":");

                String enchantName = parts[0].replace(" ", "_").toUpperCase();
                int level = 0;

                if (parts.length > 1)
                    level = Integer.parseInt(parts[1]);

                Enchantment type = Enchantment.getByName(enchantName);

                if (type == null)
                    throw new AssemblerException("Unknown enchantment \"" + enchantName + "\"");

                enchantments.add(new Enchant(type, level));
            }
        }
    }
}
