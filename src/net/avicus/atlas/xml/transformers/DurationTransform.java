package net.avicus.atlas.xml.transformers;

import net.avicus.atlas.xml.data.Duration;
import org.simpleframework.xml.transform.Transform;

public class DurationTransform implements Transform<Duration> {
    @Override
    public Duration read(String s) throws Exception {
        return new Duration(s);
    }

    @Override
    public String write(Duration duration) throws Exception {
        return duration.toString();
    }
}
