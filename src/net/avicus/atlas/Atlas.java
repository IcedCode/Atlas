package net.avicus.atlas;

import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.data.*;
import net.avicus.atlas.xml.transformers.*;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import org.simpleframework.xml.transform.RegistryMatcher;

import java.io.InputStream;
import java.util.UUID;

public class Atlas {

    public static void main(String[] arg) throws Exception {
        InputStream input = ClassLoader.getSystemClassLoader().getResourceAsStream("map.xml");

        RegistryMatcher rm = new RegistryMatcher();

        {
            rm.bind(UUID.class, UUIDTransform.class);
            rm.bind(Version.class, VersionTransform.class);

            rm.bind(ItemSlot.class, ItemSlotTransform.class);
            rm.bind(Position.class, PositionTransform.class);
            rm.bind(TeamColor.class, TeamColorTransform.class);

            rm.bind(Duration.class, DurationTransform.class);
        }

        Serializer serializer = new Persister(rm);
        Map example = serializer.read(Map.class, input);

        System.out.println(example);
    }

}
