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
    String loadoutId;

    @Getter
    Loadout loadout;

    @Override
    public String getDefaultVar() {
        return "player";
    }

    @Override
    public boolean validate() {
        return var.equals(getDefaultVar());
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        super.assemble(map);

        loadout = map.getLoadoutById(loadoutId);
        if (loadout == null)
            throw new AssemblerException("Unknown loadout: \"" + loadoutId + "\"");
    }
}
