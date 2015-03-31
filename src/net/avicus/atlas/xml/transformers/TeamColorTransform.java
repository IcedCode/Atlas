package net.avicus.atlas.xml.transformers;

import net.avicus.atlas.xml.data.TeamColor;
import org.simpleframework.xml.transform.Transform;

public class TeamColorTransform implements Transform<TeamColor> {

    @Override
    public TeamColor read(String raw) throws Exception {
        return TeamColor.findByName(raw);
    }

    @Override
    public String write(TeamColor color) throws Exception {
        return color.getName();
    }
}
