package net.avicus.atlas.xml.elements.event;

import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;

@ToString(callSuper = true)
public class Damage extends GameEvent {
    @Override
    public void assemble(Map map) throws AssemblerException {

    }
}
