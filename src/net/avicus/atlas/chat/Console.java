package net.avicus.atlas.chat;

import net.avicus.atlas.chat.locale.Locale;
import net.avicus.atlas.chat.locale.LocalizedMessage;

public class Console {

    private static Locale en = Locale.getByName("en");

    public static void log(LocalizedMessage string) {
        System.out.println(string.translate(en));
    }

}
