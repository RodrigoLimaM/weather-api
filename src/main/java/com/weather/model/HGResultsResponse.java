package com.weather.model;

import lombok.Data;

import java.util.List;

@Data
public class HGResultsResponse {
    Integer temp;

    String description;

    List<HGForecastResponse> forecast;
}
