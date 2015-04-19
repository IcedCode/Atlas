package net.avicus.atlas.xml.components;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.data.Duration;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

@ToString
public class Effect implements Assembler {

    @Getter
    @Text
    String name;

    @Getter
    @Attribute(required = false)
    int amplifier = 1;

    @Getter
    @Attribute(required = false)
    Duration duration = new Duration(-1);

    @Override
    public void assemble(Map map) throws AssemblerException {
        if (amplifier <= 0)
            throw new AssemblerException("Effect amplifier must be greater than 0");
    }
}
