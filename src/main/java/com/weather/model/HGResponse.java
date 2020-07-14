package com.weather.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class HGResponse {

    private String by;

    private HGResultsResponse results;

    @Data
    @Builder
    public static class HGResultsResponse {

        private Integer temp;

        private String description;

        private List<HGForecastResponse> forecast;
    }

    @Data
    @Builder
    public static class HGForecastResponse {

        private Integer max;

        private Integer min;

        private String date;

        private String description;
    }
}
