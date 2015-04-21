package net.avicus.atlas.chat.locale;

import lombok.Getter;
import lombok.ToString;
import org.simpleframework.xml.Root;

import java.lang.reflect.Field;
import java.util.Map;

@Root
public class Lang extends LocalizedMessage {

    public static Lang CONSOLE_BOOT = new Lang("console", "boot");
    public static Lang CONSOLE_SHUTDOWN = new Lang("console", "shutdown");
    public static Lang CONSOLE_STATE_CHANGE = new Lang("console", "state-change");

    public static Lang UI_VERSION = new Lang("ui", "version");
    public static Lang UI_VERSION_LATEST = new Lang("ui", "version-latest");
    public static Lang UI_VERSION_UPDATE = new Lang("ui", "version-update");

    public static Lang ERROR_INVALID_ARGUMENTS = new Lang("error", "invalid-arguments");
    public static Lang ERROR_NO_PERMISSION = new Lang("error", "no-permission");
    public static Lang ERROR_ERROR_OCCURRED = new Lang("error", "error-occurred");

    @Getter final String category;
    @Getter final String id;

    public Lang(String category, String id) {
        this.category = category;
        this.id = id;
    }

    public LocalizedMessage with(Object... args) {
        return new LocalizedMessage(this, args);
    }

    @Override
    public String translate(Locale locale) {
        return getValue(locale);
    }

    public String getValue(Locale locale) {
        try {
            Field field = Locale.class.getDeclaredField(category);
            field.setAccessible(true);
            Map map = (Map) field.get(locale);
            if (map.containsKey(id))
                return (String) map.get(id);
        } catch (Exception e) {
            // uh oh.
        }

        throw new RuntimeException("Unknown lang: \"" + this + "\"");
    }

    public String toString() {
        return category + "/" + id;
    }

}
