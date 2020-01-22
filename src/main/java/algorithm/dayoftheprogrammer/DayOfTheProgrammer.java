package algorithm.dayoftheprogrammer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DayOfTheProgrammer {
    private int dayOfTheProgrammer = 256;
    private Logger logger = LogManager.getLogger(this.getClass());

    public String dayOfProgrammer(int year) {
        validator(year);
        Calendar calendar = getCalculatedCalendar(year);
        return getDate(calendar);
    }

    private void validator(int year) {
        if (year < 1700 || year > 2700)
            throw new RuntimeException("YEAR_OUT_OF_LIMIT");
    }

    private String getDate(Calendar calendar) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(calendar.getTime());
    }

    private Calendar getCalculatedCalendar(int year) {
        int month = 0;

        Calendar gregorianCalendar = new GregorianCalendar(year, month, 1);
        while (calculateDayByYear(gregorianCalendar) < 256) {
            gregorianCalendar.add(Calendar.MONTH, 1);
        }

        gregorianCalendar.add(Calendar.MONTH, -1);
        gregorianCalendar.add(Calendar.DATE, dayOfTheProgrammer - calculateDayByYear(gregorianCalendar));

        if (isJulianLeafAdjust(gregorianCalendar)) gregorianCalendar.add(Calendar.DATE, -1);

        return gregorianCalendar;
    }

    private int calculateDayByYear(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * Julian 윤년이나 Gregorian 윤년이 아닌 경우 true
     * @param calendar
     * @return
     */
    private boolean isJulianLeafAdjust(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        boolean isJulianLeaf = (year % 4 == 0);
        boolean isGregorianLeaf = (year % 400 == 0) || (isJulianLeaf && year % 100 > 0);
        return (isGregorianLeaf == false && isJulianLeaf == true) ? true : false;
    }
}
