package net.avicus.atlas.xml.data;

import lombok.Getter;
import lombok.ToString;

@ToString
public class Version {

    @Getter int major;
    @Getter int minor;
    @Getter int patch;

    public Version(int major, int minor, int patch) {
        this.major = major;
        this.minor = minor;
        this.patch = patch;
    }

    @Override
    public String toString() {
        return major + "." + minor + "." + patch;
    }

}
