package net.avicus.atlas.xml.transformers;

import org.simpleframework.xml.transform.Transform;

import java.util.UUID;

public class UUIDTransform implements Transform<UUID> {

    @Override
    public UUID read(String raw) throws Exception {
        raw = raw.replace("-", "");
        raw = raw.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
        return UUID.fromString(raw);
    }

    @Override
    public String write(UUID uuid) throws Exception {
        return uuid.toString();
    }
}
