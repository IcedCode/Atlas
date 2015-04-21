package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Cuboid extends Region {

    @Attribute
    Position min;

    @Attribute
    Position max;

    @Override
    public void assemble(Map map) throws AssemblerException {
        Position newMin = new Position(0, 0, 0);
        Position newMax = new Position(0, 0, 0);

        newMin.setX(Math.min(min.getX(), max.getX()));
        newMin.setY(Math.min(min.getY(), max.getY()));
        newMin.setZ(Math.min(min.getZ(), max.getZ()));

        newMax.setX(Math.max(min.getX(), max.getX()));
        newMax.setY(Math.max(min.getY(), max.getY()));
        newMax.setZ(Math.max(min.getZ(), max.getZ()));

        min = newMin;
        max = newMax;
    }

    @Override
    public Position getRandomPosition() {
        return null;
    }
}
