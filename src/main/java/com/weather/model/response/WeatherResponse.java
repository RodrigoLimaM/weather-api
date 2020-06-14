package com.weather.model.response;

import lombok.Data;

@Data
public class WeatherResponse {

    String by;

    WeatherResultsResponse results;
}
