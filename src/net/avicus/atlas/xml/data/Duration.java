package net.avicus.atlas.xml.data;

import lombok.Getter;
import lombok.ToString;
import org.joda.time.Period;
import org.joda.time.format.PeriodFormatter;
import org.joda.time.format.PeriodFormatterBuilder;

@ToString
public class Duration {

    @Getter double seconds;

    public Duration(double seconds) {
        this.seconds = seconds;
    }

    public Duration(String parse) {
        PeriodFormatter formatter = new PeriodFormatterBuilder()
                .appendDays().appendSuffix("d")
                .appendHours().appendSuffix("h")
                .appendMinutes().appendSuffix("m")
                .appendSeconds().appendSuffix("s")
                .toFormatter();

        parse = parse.replace(" ", "");

        Period p = formatter.parsePeriod(parse);
        this.seconds = p.toStandardSeconds().getSeconds();
    }

}
