package com.weather.service.util;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DateConversionService {

    public LocalDate convertDate(String date) {
        date += "/0";
        String[] yearMonthDay = date.split("/");
        return LocalDate.of(LocalDate.now().getYear(),
                stringToInt(yearMonthDay[1]),
                stringToInt(yearMonthDay[0]));
    }

    private Integer stringToInt(String field){
        return Integer.parseInt(field);
    }
}
