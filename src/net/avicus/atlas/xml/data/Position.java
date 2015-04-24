package net.avicus.atlas.xml.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Location;
import org.bukkit.World;

public class Position {

    @Getter @Setter double x;
    @Getter @Setter double y;
    @Getter @Setter double z;
    @Getter @Setter double yaw;
    @Getter @Setter double pitch;

    public Position(Location location) {
        this(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
    }

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

    public Location toLocation(World world) {
        return new Location(world, x, y, z, (float) yaw, (float) pitch);
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

    public boolean equals(Position test) {
        if (Math.floor(test.x) == Math.floor(x))
            if (Math.floor(test.y) == Math.floor(y))
                if (Math.floor(test.z) == Math.floor(z))
                    return true;
        return false;
    }

}
