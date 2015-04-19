package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Effect;
import net.avicus.atlas.xml.components.Item;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public class Loadout implements Assembler {

    @Getter
    @Attribute
    String name;

    @Getter
    @ElementList(name="item", type=Item.class, inline = true, required = false)
    List<Item> items;

    @ElementList(name="effect", type=Effect.class, inline = true, required = false)
    List<Effect> effects;

    @Override
    public void assemble(Map map) throws AssemblerException {
        for (Item item : items)
            item.assemble(map);
        for (Effect effect : effects)
            effect.assemble(map);
    }
}
