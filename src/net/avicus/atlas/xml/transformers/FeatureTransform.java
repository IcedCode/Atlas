package net.avicus.atlas.xml.transformers;

import net.avicus.atlas.xml.components.FeatureType;
import org.simpleframework.xml.transform.Transform;

public class FeatureTransform implements Transform<FeatureType> {

    @Override
    public FeatureType read(String raw) throws Exception {
        return FeatureType.valueOf(raw.replace("-", "_").toUpperCase());
    }

    @Override
    public String write(FeatureType feature) throws Exception {
        return feature.name().toLowerCase();
    }
}
