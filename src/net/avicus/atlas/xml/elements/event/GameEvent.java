package net.avicus.atlas.xml.elements.event;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Condition;
import net.avicus.atlas.xml.elements.ConditionSet;
import net.avicus.atlas.xml.elements.event.action.*;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;

import java.util.List;

@ToString
public abstract class GameEvent implements Assembler {

    @Getter
    @Attribute(name = "condition", required = false)
    String conditionName;

    @Getter
    @ElementListUnion({
            @ElementList(entry = "message", type=Message.class, inline = true),
            @ElementList(entry = "teleport", type=Teleport.class, inline = true),
            @ElementList(entry = "apply-loadout", type=ApplyLoadout.class, inline = true),
            @ElementList(entry = "cancel", type=Cancel.class, inline = true),
            @ElementList(entry = "push", type=Push.class, inline = true)
    })
    List<Action> actions;

    @Getter
    ConditionSet condition;

    public <T extends Action> T getAction(Class<T> type) {
        for (Action action : actions)
            if (action.getClass() == type)
                return (T) action;
        return null;
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        condition = map.getConditionByName(conditionName);
        if (conditionName != null && condition == null)
            throw new AssemblerException("Unknown condition: \"" + conditionName + "\"");
        for (Action action : actions)
            action.assemble(map);
    }

}
