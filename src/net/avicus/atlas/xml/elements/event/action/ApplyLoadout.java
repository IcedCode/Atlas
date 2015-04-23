package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.elements.Loadout;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString(callSuper = true)
public class ApplyLoadout extends Action {

    @Getter
    @Attribute
    boolean clear;

    @Getter
    @Text
    String name;

    @Getter
    Loadout loadout;

    @Override
    public void assemble(Map map) throws AssemblerException {
        loadout = map.getLoadoutById(name);
        if (loadout == null)
            throw new AssemblerException("Unknown loadout: \"" + name + "\"");
    }
}
