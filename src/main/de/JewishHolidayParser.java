package de;

import de.jollyday.Holiday;
import de.jollyday.HolidayType;
import de.jollyday.config.Holidays;
import de.jollyday.config.JewishHoliday;
import de.jollyday.parser.AbstractHolidayParser;
import net.sourceforge.zmanim.hebrewcalendar.JewishCalendar;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Set;

public class JewishHolidayParser extends AbstractHolidayParser {

    private static final String PREFIX_PROPERTY_JEWISH = "jewish";

    @Override
    public void parse(int year, Set<Holiday> holidays, Holidays config) {
        for (JewishHoliday f : config.getJewishHoliday()) {
            if (!isValid(f, year)) {
                continue;
            }
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR,year);
            JewishCalendar calendar = new JewishCalendar(c);

            for (int day = 0; day < f.getLength(); day++) {
                calendar.setJewishMonth(f.getMonth().ordinal() + 1);
                calendar.setJewishDayOfMonth(f.getDay() + day);
                Calendar gc = calendar.getGregorianCalendar();
                LocalDate date = gc.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                HolidayType type = xmlUtil.getType(f.getLocalizedType());
                Holiday h = new Holiday(date, f.getDescriptionPropertiesKey(), type);
                holidays.add(h);
            }

        }
    }
}
