package net.avicus.atlas.xml.transformers;

import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.transform.Transform;

public class PositionTransform implements Transform<Position> {

    @Override
    public Position read(String raw) throws Exception {
        String[] parts = raw.split(",");

        if (parts.length < 3)
            throw new TransformException(this, raw);

        double x = 0, y = 0, z = 0, yaw = 0, pitch = 0;

        for (int i = 0; i < parts.length; i++) {
            double val = Double.parseDouble(parts[i]);
            if (i == 0)
                x = val;
            else if (i == 1)
                y = val;
            else if (i == 2)
                z = val;
            else if (i == 3)
                yaw = val;
            else if (i == 4)
                pitch = val;
        }

        return new Position(x, y, z, yaw, pitch);
    }

    @Override
    public String write(Position position) throws Exception {
        return position.toString();
    }
}
