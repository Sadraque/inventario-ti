package com.iventarioti.util;

import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class DateUtils {

    final private static String simpleDateFormatDefaultPattern = "dd/MM/yyyy";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(simpleDateFormatDefaultPattern);

    private static Calendar calendar = Calendar.getInstance();

    public static Date getCurrentDate() {
        return calendar.getTime();
    }

    public static String formatDate(Date date) {
        return simpleDateFormat.format(date);
    }
}