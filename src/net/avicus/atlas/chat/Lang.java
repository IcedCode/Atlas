package net.avicus.atlas.chat;

import lombok.ToString;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.ElementMapUnion;
import org.simpleframework.xml.Root;

import java.util.Map;

@ToString
@Root
public class Lang {

    @ElementMapUnion(value = {
            @ElementMap(entry = "msg", key = "id", attribute = true, inline = true),
            @ElementMap(entry = "error", key = "id", attribute = true, inline = true)
    })
    Map<String,String> locale;

}
