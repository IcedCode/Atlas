package net.avicus.atlas.chat.locale;

import lombok.Getter;

import java.text.MessageFormat;

public class LocalizedMessage {

    @Getter Lang lang;
    @Getter Object[] args;

    public LocalizedMessage(Lang lang, Object... args) {
        this.lang = lang;
        this.args = args;
    }

    protected LocalizedMessage() {

    }

    public String translate(Locale locale) {
        return MessageFormat.format(lang.getValue(locale), args);
    }

}
