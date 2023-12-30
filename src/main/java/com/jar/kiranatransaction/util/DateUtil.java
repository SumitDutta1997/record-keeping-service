package com.jar.kiranatransaction.util;

import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@UtilityClass
public class DateUtil {

    public LocalDate convertToLocalDate(Date date) {

        return convertToLocalDate(date, "Asia/Kolkata");
    }

    public LocalDate convertToLocalDate(Date date, String timeZone) {

        if (date == null) {
            return null;
        }

        if (date instanceof java.sql.Date) {
            return ((java.sql.Date) date).toLocalDate();
        }

        ZoneId zoneId = ZoneId.of(timeZone);
        Instant instant = date.toInstant();
        return instant.atZone(zoneId).toLocalDate();
    }
}
