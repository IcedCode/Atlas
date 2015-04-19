package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.ItemSlot;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString
public class Item implements Condition {

    @Getter
    @Text
    String name;

    @Getter
    @Attribute(required = false)
    ItemSlot slot;

    @Getter
    @Attribute(required = false)
    int count = 1;

    @Getter
    @Attribute(required = false)
    String enchantment;

    @Getter
    @Attribute(required = false)
    String lore;

    @Override
    public void assemble(Map map) throws AssemblerException {

    }
}
