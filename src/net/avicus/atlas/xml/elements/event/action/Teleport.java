package net.avicus.atlas.xml.elements.event.action;

import lombok.Getter;
import lombok.ToString;
import net.avicus.atlas.xml.Map;
import net.avicus.atlas.xml.assembler.AssemblerException;
import net.avicus.atlas.xml.components.Spawn;
import net.avicus.atlas.xml.data.Position;
import org.simpleframework.xml.Attribute;

@ToString(callSuper = true)
public class Teleport extends Action {

    @Attribute(required = false)
    Position location;

    @Getter
    @Attribute(name = "spawn", required = false)
    String spawnId;

    @Getter
    Spawn spawn;

    public Position getPosition() {
        if (location == null)
            return spawn.getRegions().getRandomPosition();
        return location;
    }

    @Override
    public String getDefaultVar() {
        return "player";
    }

    @Override
    public boolean validate() {
        return var.equals(getDefaultVar());
    }

    @Override
    public void assemble(Map map) throws AssemblerException {
        super.assemble(map);

        if (spawnId != null) {
            if (location != null)
                throw new AssemblerException("Attributes spawn and location provided in teleport action but only one is necessary.");
            spawn = map.getSpawnById(spawnId);
            if (spawn == null)
                throw new AssemblerException("Unknown spawn: \"" + spawnId + "\"");
        }

    }

}
