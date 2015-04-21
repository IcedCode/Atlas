package net.avicus.atlas.chat.locale;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.Atlas;
import org.simpleframework.xml.ElementMap;
import org.simpleframework.xml.Root;

import java.util.HashMap;
import java.util.Map;

@ToString
@Root
public class Locale {

    @Getter static HashMap<String, Locale> list = new HashMap<String, Locale>();

    static {
        try {
            list.put("en", initialize("en"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Locale getDefault() {
        return getByName("en");
    }

    public static Locale getByName(String name) {
        Locale locale = list.get(name.substring(0, 2));
        return locale == null ? Locale.getDefault() : locale;
    }

    public static Locale initialize(String name) throws Exception {
        return Atlas.getSerializer().read(Locale.class, Locale.class.getResourceAsStream("/locale/" + name + ".xml"));
    }

    public Locale() {

    }

    public String translate(Lang lang) {
        return lang.getValue(this);
    }

    @Root
    @ElementMap(key = "id", attribute = true)
    private Map<String,String> console;

    @Root
    @ElementMap(key = "id", attribute = true)
    private Map<String,String> ui;

    @Root
    @ElementMap(key = "id", attribute = true)
    private Map<String,String> error;

}
