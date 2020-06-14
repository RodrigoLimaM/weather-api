package com.weather.model;

import lombok.Data;

import java.util.List;

@Data
public class HGResultsResponse {

    private Integer temp;

    private String description;

    private List<HGForecastResponse> forecast;
}
