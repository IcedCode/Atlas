package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Circle extends Region {

    @Attribute
    Position center;

    @Attribute
    int radius;

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (radius < 0)
            throw new AssemblerException("Cannot have radius of less than 0");
    }

    @Override
    public boolean isInside(Position position) {
        return false;
    }

    @Override
    public Position getRandomPosition() {
        return null;
    }
}
