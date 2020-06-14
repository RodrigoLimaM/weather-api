package com.weather.model.response;

import lombok.Data;

import java.util.List;

@Data
public class WeatherResultsResponse {
    Integer temp;

    String description;

    List<WheatherForecastResponse> forecast;
}
