package com.weather.model;

import lombok.Data;

@Data
public class HGResponse {

    private String by;

    private HGResultsResponse results;
}
