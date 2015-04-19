package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import org.simpleframework.xml.Attribute;

@ToString(callSuper = true)
public class Push extends Action {

    @Getter
    @Attribute
    double velocity;

    @Getter
    @Attribute
    double vertical;

    @Override
    public void assemble(Map map) throws AssemblerException {
        // Nothing to check
    }
}
