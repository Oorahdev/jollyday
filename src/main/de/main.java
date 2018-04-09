package de;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import de.jollyday.ManagerParameter;
import de.jollyday.ManagerParameters;
import de.jollyday.impl.DefaultHolidayManager;

public class main {

    public static void main(String[] args) {
        ManagerParameter params = ManagerParameters.create(HolidayCalendar.UNITED_STATES);
        HolidayManager manager = HolidayManager.getInstance(params);
        manager.getHolidays(2018).parallelStream().forEach(System.out::println);

    }
}
