package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Global extends Region {

    @Override
    public void assemble(Map map) throws AssemblerException {

    }

    @Override
    public boolean isInside(Position position) {
        return true;
    }

    @Override
    public Position getRandomPosition() {
        return null;
    }
}
