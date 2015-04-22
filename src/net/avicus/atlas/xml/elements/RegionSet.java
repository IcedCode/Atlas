package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.chat.Console;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.components.region.*;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

@ToString
public class RegionSet extends Region implements Condition,Iterable<Region> {

    @Getter
    @ElementListUnion({
            @ElementList(name="point", type=Point.class, inline = true),
            @ElementList(name="cuboid", type=Cuboid.class, inline = true),
            @ElementList(name="cylinder", type=Cylinder.class, inline = true),
            @ElementList(name="circle", type=Circle.class, inline = true),
            @ElementList(name="global", type=Global.class, inline = true)
    })
    List<Region> list;

    @Override
    public void assemble(Map map) throws AssemblerException {
        for (Region region : list)
            region.assemble(map);
    }

    @Override
    public Iterator<Region> iterator() {
        return list.iterator();
    }

    @Override
    public boolean isInside(Position position) {
        for (Region region : list)
            if (region.isInside(position))
                return true;
        return false;
    }

    @Override
    public Position getRandomPosition() {
        return list.get(new Random().nextInt(list.size())).getRandomPosition();
    }

}
