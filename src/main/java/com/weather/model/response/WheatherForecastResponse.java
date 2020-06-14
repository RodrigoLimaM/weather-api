package com.weather.model.response;

import lombok.Data;

@Data
public class WheatherForecastResponse {
    Integer max;

    Integer min;

    String date;

    String description;
}
