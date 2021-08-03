package com.iventarioti.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTests {

    @Test
    public void getCurrentDate() {
        Date currentDate = DateUtils.getCurrentDate();
        Assertions.assertNotNull(DateUtils.getCurrentDate());

        System.out.println("Current Date: " +currentDate.toString());
    }

    @Test
    public void formatDate() {
        Date date = Calendar.getInstance().getTime();
        String formatedDate = DateUtils.formatDate(date);

        Assertions.assertNotEquals(date.toString(), formatedDate);

        System.out.println("Date: " +date.toString());
        System.out.println("Formated Date: " +formatedDate);
    }
}
