package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.data.Position;

@ToString
public abstract class Region implements Assembler {

    public abstract boolean isInside(Position position);

    public abstract Position getRandomPosition();

}
