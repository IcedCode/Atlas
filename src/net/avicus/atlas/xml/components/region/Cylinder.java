package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString
public class Cylinder extends Region {

    @Attribute
    Position center;

    @Attribute
    int radius;

    @Attribute
    int height;

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (radius < 0)
            throw new AssemblerException("Cannot have radius of less than 0");
        if (height < 0)
            throw new AssemblerException("Cannot have height of less than 0");
    }

}
