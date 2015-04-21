package net.avicus.atlas.xml.components.region;

import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Text;

@ToString
public class Point extends Region {

    @Text
    Position position;

    @Override
    public void assemble(Map map) throws AssemblerException {

    }

    @Override
    public Position getRandomPosition() {
        return position;
    }

}
