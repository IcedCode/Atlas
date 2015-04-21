package net.avicus.atlas.xml.data;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class TeamColor {

    private static List<TeamColor> list = new ArrayList<TeamColor>();

    public static TeamColor AQUA = new TeamColor("AQUA", "AQUA", "CYAN");
    public static TeamColor RED = new TeamColor("RED", "RED", "RED");
    public static TeamColor BLUE = new TeamColor("BLUE", "BLUE", "LIGHT_BLUE");
    public static TeamColor GREEN = new TeamColor("GREEN", "DARK_GREEN", "GREEN");
    public static TeamColor LIME = new TeamColor("LIME", "GREEN", "LIME");
    public static TeamColor YELLOW = new TeamColor("YELLOW", "YELLOW", "YELLOW");
    public static TeamColor ORANGE = new TeamColor("ORANGE", "GOLD", "ORANGE");
    public static TeamColor PURPLE = new TeamColor("PURPLE", "DARK_PURPLE", "PURPLE");
    public static TeamColor PINK = new TeamColor("PINK", "LIGHT_PURPLE", "PINK");

    @Getter String name;
    @Getter String textColor;
    @Getter String dyeColor;

    private TeamColor(String name, String textColor, String dyeColor) {
        this.name = name;
        this.textColor = textColor;
        this.dyeColor = dyeColor;
        list.add(this);
    }

    public static TeamColor getByName(String name) throws Exception {
        for (TeamColor color : list)
            if (color.getName().equalsIgnoreCase(name))
                return color;
        throw new Exception("Unknown team color: " + name);
    }

}
