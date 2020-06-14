package com.weather.model;

import lombok.Data;

@Data
public class HGForecastResponse {

    private Integer max;

    private Integer min;

    private String date;

    private String description;
}
