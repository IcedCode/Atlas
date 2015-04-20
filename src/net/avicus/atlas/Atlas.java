package net.avicus.atlas;

import net.avicus.atlas.chat.Lang;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.data.*;
import net.avicus.atlas.xml.transformers.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;
import java.util.UUID;

public class Atlas {

    public static void main(String[] args) throws Exception {
        System.out.println("Executing locale tests...");

        Lang lang = getSerializer().read(Lang.class, ClassLoader.getSystemClassLoader().getResourceAsStream("lang/en.xml"));

        System.out.println(lang.toString());
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
