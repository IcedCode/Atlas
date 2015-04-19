package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.components.region.*;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.Iterator;
import java.util.List;

@ToString
public class RegionSet implements Condition,Iterable<Region> {

    @Getter
    @ElementListUnion({
            @ElementList(name="point", type=Point.class, inline = true),
            @ElementList(name="cuboid", type=Cuboid.class, inline = true),
            @ElementList(name="cylinder", type=Cylinder.class, inline = true),
            @ElementList(name="circle", type=Circle.class, inline = true)
    })
    List<Region> list;

    @Override
    public Iterator<Region> iterator() {
        return list.iterator();
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        for (Region region : list)
            region.assemble(map);
    }
}
