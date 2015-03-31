package net.avicus.atlas.xml.data;

import lombok.Getter;
import lombok.Setter;

public class Position {

    @Getter @Setter double x;
    @Getter @Setter double y;
    @Getter @Setter double z;
    @Getter @Setter double yaw;
    @Getter @Setter double pitch;

    public Position(double x, double y, double z, double yaw, double pitch) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public Position(double x, double y, double z) {
        this(x, y, z, 0, 0);
    }

    @Override
    public String toString() {
        String output = x + "," + y + "," + z;
        if (yaw != 0 || pitch != 0)
            output += "," + yaw;
        if (pitch != 0)
            output += "," + pitch;
        return output;
    }

}
