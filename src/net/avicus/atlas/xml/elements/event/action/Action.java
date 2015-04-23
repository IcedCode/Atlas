package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.Assembler;
import net.avicus.atlas.xml.assembler.AssemblerException;
import org.simpleframework.xml.Attribute;

@ToString
public abstract class Action implements Assembler {

    @Getter
    @Attribute(required = false)
    int priority;

    @Getter
    @Attribute(required = false)
    String var;

    public abstract String getDefaultVar();

    /**
     * Checks if the 'var' attribute is valid for the particular
     * action. For instance, the Teleport action can only accept
     * 'team' or 'player' as a value since those are the two objects
     * that can be teleported.
     * @return
     */
    public abstract boolean validate();

    public void assemble(Map map) throws AssemblerException {
        if (var == null)
            var = getDefaultVar();
        boolean pass = validate();
        if (!pass)
            throw new AssemblerException("Invalid var value \"" + getVar() + "\"");
    }

}
