package com.weather.model;

import lombok.Data;

@Data
public class HGForecastResponse {
    Integer max;

    Integer min;

    String date;

    String description;
}
