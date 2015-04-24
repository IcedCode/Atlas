package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import org.simpleframework.xml.Text;

@ToString(callSuper = true)
public class Merge extends Action {

    @Getter
    @Text(required = false)
    boolean enabled = true;

    @Override
    public String getDefaultVar() {
        return "event";
    }

    @Override
    public boolean validate() {
        return var.equals(getDefaultVar());
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        super.assemble(map);
    }
}
