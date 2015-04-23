package net.avicus.atlas.xml.elements;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.components.Item;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public class ConditionSet implements Assembler {

    @Getter
    @Attribute
    String id;

    @Getter
    @Attribute(required = false)
    String require = "one";

    @Getter
    @ElementListUnion({
            @ElementList(name="item", type=Item.class, inline = true),
            @ElementList(entry="region", type=RegionSet.class, inline = true)
    })
    List<Condition> list;

    @Override
    public void assemble(Map map) throws AssemblerException {
        for (Condition condition : list)
            condition.assemble(map);
    }
}
