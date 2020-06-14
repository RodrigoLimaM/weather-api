package com.weather.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WeatherForecast {

    private LocalDate date;

    private Integer max;

    private Integer min;

    private String description;
}
