package net.avicus.atlas.rotation;

import java.io.File;
import java.io.InputStream;

/**
 * A map world and corresponding configuration file located somewhere outside
 * of the server root directory. It is intended to be relocated to the root
 * directory and assmebled into a Map.
 */
public interface MapPacket {

    public void prepare() throws Exception;

    public void move(File directory) throws Exception;

    public InputStream getConfig() throws Exception;

}
