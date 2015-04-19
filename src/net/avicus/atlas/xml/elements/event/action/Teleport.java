package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString(callSuper = true)
public class Teleport extends Action {

    @Getter
    @Attribute
    Position location;

    @Override
    public void assemble(Map map) throws AssemblerException {
        // Nothing to check
    }
}
