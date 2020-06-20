package io.interfiber.Pizza.coreFunctions;

import io.interfiber.Pizza.lang.VarExistsException;
import org.joda.time.DateTime;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class Time {

    public static void getDateTime(String varOut) throws IOException {
        java.util.Date juDate = new Date();
        DateTime dt = new DateTime(juDate);
        int mounth = dt.getMonthOfYear();
        int year = dt.getYear();
        int day = dt.getDayOfMonth();
        int week = dt.getWeekyear();
        int hour = dt.getHourOfDay();
        int min = dt.getMinuteOfHour();
        int sec = dt.getSecondOfMinute();
        String out = String.valueOf(year) + ":" + String.valueOf(mounth) + ":" + String.valueOf(week) + ":" + String.valueOf(day) + ":" + String.valueOf(hour) + ":" + String.valueOf(min) + ":" + String.valueOf(sec);
        if(new File(Variable.getVarPath(varOut)).exists()){
            try {
                throw new VarExistsException(varOut);
            } catch (VarExistsException e) {
                e.printStackTrace();
            }
        }
        Variable.create(varOut, out);
    }
}
