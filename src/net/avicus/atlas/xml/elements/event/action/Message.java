package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Text;

@ToString
public class Message extends Action {

    @Getter
    @Text
    String message;

}
