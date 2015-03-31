package net.avicus.atlas.xml.transformers;

import net.avicus.atlas.xml.data.ItemSlot;
import org.simpleframework.xml.transform.Transform;

public class ItemSlotTransform implements Transform<ItemSlot> {
    @Override
    public ItemSlot read(String s) throws Exception {
        return new ItemSlot(s);
    }

    @Override
    public String write(ItemSlot itemSlot) throws Exception {
        return itemSlot.toString();
    }
}
