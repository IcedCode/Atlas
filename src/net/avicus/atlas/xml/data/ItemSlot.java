package net.avicus.atlas.xml.data;

import lombok.Getter;

public class ItemSlot {

    @Getter int value;

    public ItemSlot(String input) {
        if (input.equalsIgnoreCase("helmet"))
            value = 103;
        else if (input.equalsIgnoreCase("chestplate"))
            value = 102;
        else if (input.equalsIgnoreCase("leggings"))
            value = 101;
        else if (input.equalsIgnoreCase("boots"))
            value = 100;
        else
            value = Integer.parseInt(input);
    }

    public ItemSlot(int value) {
        this.value = value;
    }

    public String toString() {
        return value + "";
    }

}
