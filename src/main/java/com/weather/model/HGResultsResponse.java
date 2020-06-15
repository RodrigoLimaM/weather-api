package com.weather.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HGResultsResponse {

    private Integer temp;

    private String description;

    private List<HGForecastResponse> forecast;
}
