package de;

import de.jollyday.HolidayCalendar;
import de.jollyday.HolidayManager;
import de.jollyday.ManagerParameter;
import de.jollyday.ManagerParameters;

public class app {

    public static void main(String[] args) {

        ManagerParameter params = ManagerParameters.create(HolidayCalendar.UNITED_STATES);

        HolidayManager manager = HolidayManager.getInstance(params);
        manager.getHolidays(2016).parallelStream().forEach((h) -> {
            System.out.println(h.getType());
        });
    }
}
