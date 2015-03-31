package net.avicus.atlas;

import net.avicus.atlas.xml.data.Position;
import net.avicus.atlas.xml.data.Version;
import net.avicus.atlas.xml.data.TeamColor;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.transformers.PositionTransform;
import net.avicus.atlas.xml.transformers.TeamColorTransform;
import net.avicus.atlas.xml.transformers.UUIDTransform;
import net.avicus.atlas.xml.transformers.VersionTransform;
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
            rm.bind(Position.class, PositionTransform.class);
        }

        {
            rm.bind(TeamColor.class, TeamColorTransform.class);
        }

        Serializer serializer = new Persister(rm);
        Map example = serializer.read(Map.class, input);

        System.out.println(example);
    }

}
