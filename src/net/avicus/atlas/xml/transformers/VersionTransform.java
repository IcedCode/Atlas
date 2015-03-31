package net.avicus.atlas.xml.transformers;

import net.avicus.atlas.xml.data.Version;
import org.simpleframework.xml.transform.Transform;

public class VersionTransform implements Transform<Version> {

    @Override
    public Version read(String raw) throws Exception {
        String[] parts = raw.split("\\.");

        int major = 1;
        int minor = 0;
        int patch = 0;

        for (int i = 0; i < parts.length; i++) {
            if (i == 0)
                major = Integer.parseInt(parts[i]);
            if (i == 1)
                minor = Integer.parseInt(parts[i]);
            if (i == 2)
                patch = Integer.parseInt(parts[i]);
        }

        return new Version(major, minor, patch);
    }

    @Override
    public String write(Version version) throws Exception {
        return version.toString();
    }
}
