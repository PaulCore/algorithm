package my.boring;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Created by paul on 2015/7/3.
 */
public class CalendarTest {
    public static void main(String[] args) {
        GregorianCalendar d = new GregorianCalendar(Locale.CHINA);

        int today = d.get(Calendar.DAY_OF_MONTH);
        int month = d.get(Calendar.MONTH);

        //设置为当月的第一天
        d.set(Calendar.DAY_OF_MONTH,1);
        //当月1号对应的星期几
        int weekday = d.get(Calendar.DAY_OF_WEEK);
        //一个星期的第一天
        int firstDayOfWeek = d.getFirstDayOfWeek();

        int indent = 0;
        while (weekday != firstDayOfWeek){
            indent++;
            d.add(Calendar.DAY_OF_MONTH,-1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        }

        String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
        do {
            System.out.printf("%4s", weekdayNames[weekday]);
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);
        } while (weekday != firstDayOfWeek);
        System.out.println();

        for (int i = 1; i <= indent; i++)
            System.out.print("       ");

        d.set(Calendar.DAY_OF_MONTH,1);
        do {
            int day = d.get(Calendar.DAY_OF_MONTH);
            System.out.printf("%3d",day);
            if (day == today)
                System.out.print("*   ");
            else System.out.print("    ");
            d.add(Calendar.DAY_OF_MONTH,1);
            weekday = d.get(Calendar.DAY_OF_WEEK);

            //当为一个星期的第一天是换一行
            if (weekday == firstDayOfWeek)
                System.out.println();
        }while (d.get(Calendar.MONTH) == month);

        if (weekday != firstDayOfWeek)
            System.out.println();

    }
}
