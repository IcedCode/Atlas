package net.avicus.atlas;

import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.chat.locale.Locale;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.data.*;
import net.avicus.atlas.xml.transformers.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Atlas {

    public static void main(String[] args) throws Exception {
        // Locale tests
        testLocale();
    }

    private static void testLocale() throws Exception {
        System.out.println("Executing locale tests...");

        Locale locale = Locale.getByName("en");

        List<Lang> langs = new ArrayList<Lang>();

        for (Field field : Lang.class.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers())) {
                langs.add((Lang) field.get(null));
            }
        }

        int i = 0;
        for (Lang lang : langs) {
            try {
                locale.translate(lang);
            } catch (Exception e) {
                System.out.println(lang.toString() + " failed!");
                e.printStackTrace();
                i++;
            }
        }

        if (i > 0)
            System.out.println("### " + i + " errors ###");
        else
            System.out.println("No errors found.");
    }

    public static Serializer getSerializer() {
        RegistryMatcher rm = new RegistryMatcher();

        {
            rm.bind(UUID.class, UUIDTransform.class);
            rm.bind(Version.class, VersionTransform.class);

            rm.bind(ItemSlot.class, ItemSlotTransform.class);
            rm.bind(Position.class, PositionTransform.class);
            rm.bind(TeamColor.class, TeamColorTransform.class);

            rm.bind(Duration.class, DurationTransform.class);
        }

        return new Persister(rm);
    }

    public static Map parse(InputStream input) throws Exception {
        Map map = getSerializer().read(Map.class, input);
        map.assemble();
        return map;
    }

}
