package net.avicus.atlas.manager.event.check;

import net.avicus.atlas.manager.event.Check;
import net.avicus.atlas.manager.event.CheckResult;
import net.avicus.atlas.xml.data.Position;
import net.avicus.atlas.xml.elements.RegionSet;
import org.bukkit.Location;

import javax.annotation.Nullable;

public class RegionCheck extends Check<RegionSet> {

    public RegionCheck() {
        super(RegionSet.class);
    }

    @Override
    public CheckResult check(RegionSet condition, @Nullable Object against) {
        if (against instanceof Location) {
            boolean inside = condition.isInside(new Position((Location) against));
            return inside ? CheckResult.SUCCESS : CheckResult.FAILED;
        }
        return CheckResult.IGNORE;
    }

}
