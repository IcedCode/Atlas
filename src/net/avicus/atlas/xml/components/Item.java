package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.util.ChatUtils;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.ItemSlot;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

import java.util.List;

@ToString
public class Item implements Condition {

    @Getter
    @Text
    String materialName;

    @Getter
    @Attribute(required = false)
    ItemSlot slot;

    @Getter
    @Attribute(required = false)
    int count = 1;

    @Getter
    @Attribute(name = "enchantments", required = false)
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
            throw new AssemblerException("Item count must be greater than 0");

        material = Material.valueOf(materialName.replace(" ", "_").toUpperCase());
        name = ChatUtils.addColors(name);
        lore = ChatUtils.addColors(lore);

        if (enchantmentRaw != null) {
            for (String enchant : enchantmentRaw.split("\\|")) {
                String[] parts = enchant.split(":");

                String enchantName = parts[0].replace(" ", "_").toUpperCase();
                int level = 0;

                if (parts.length > 1)
                    level = Integer.parseInt(parts[1]);

                enchantments.add(new Enchant(Enchantment.getByName(enchantName), level));
            }
        }
    }
}
