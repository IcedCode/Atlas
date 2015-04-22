package net.avicus.atlas;

import net.avicus.atlas.chat.locale.Lang;
import net.avicus.atlas.chat.locale.Locale;
import net.avicus.atlas.xml.components.FeatureType;
import net.avicus.atlas.xml.data.*;
import net.avicus.atlas.xml.transformers.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Atlas {

    public static void main(String[] args) throws Exception {
        // Locale tests
        testLocale();
    }

    private static void testLocale() throws Exception {
        System.out.println("Executing locale tests.");

        for (Map.Entry<String, Locale> e : Locale.getList().entrySet()) {
            System.out.println(" > " + e.getKey() + ".xml");
            List<Lang> langs = new ArrayList<Lang>();

            for (Field field : Lang.class.getDeclaredFields())
                if (Modifier.isStatic(field.getModifiers()))
                    langs.add((Lang) field.get(null));

            int i = 0;
            for (Lang lang : langs) {
                try {
                    e.getValue().translate(lang);
                } catch (Exception ex) {
                    System.out.println(lang.toString() + " failed!");
                    ex.printStackTrace();
                    i++;
                }
            }

            if (i > 0)
                System.out.println("\n### " + i + " errors ###");
            else
                System.out.println("\nNo errors found.");
        }

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
            rm.bind(FeatureType.class, FeatureTransform.class);
        }

        return new Persister(rm);
    }

}
