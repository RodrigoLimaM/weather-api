package com.weather.model;

import lombok.Data;

@Data
public class HGResponse {

    String by;

    HGResultsResponse results;
}
