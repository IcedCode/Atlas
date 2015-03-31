package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Text;

@ToString
public class Cancel extends Action {

    @Getter
    @Text(required = false)
    boolean value = true;

}
