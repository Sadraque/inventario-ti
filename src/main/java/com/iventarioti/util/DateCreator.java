package com.iventarioti.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Service
public class DateCreator {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Date getDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();

        return date;
    }

    public String formatDate(Date date) {
        return this.simpleDateFormat.format(date);
    }
}