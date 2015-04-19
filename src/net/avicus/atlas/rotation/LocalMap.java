package net.avicus.atlas.rotation;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class LocalMap implements MapPacket {

    private File folder;

    public LocalMap(File folder) {
        this.folder = folder;
    }

    @Override
    public void prepare() throws Exception {
        // Nothing to do, already downloaded and all.
    }

    @Override
    public void move(File directory) throws Exception {
        FileUtils.copyDirectory(folder, directory);
    }

    @Override
    public InputStream getConfig() throws Exception {
        return new FileInputStream(new File(folder, "map.xml"));
    }
}
