package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.util.ChatUtils;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import org.simpleframework.xml.Text;

@ToString(callSuper = true)
public class Message extends Action {

    @Getter
    @Text
    String message;

    @Override
    public String getDefaultVar() {
        return "player";
    }

    @Override
    public boolean validate() {
        return var.equals(getDefaultVar());
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        super.assemble(map);
        message = ChatUtils.addColors(message);
    }
}
