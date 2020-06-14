package com.weather.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeatherDTO {

    private String temperatureType;

    private Integer currentTemperature;

    private String description;

    private List<WeatherForecast> weatherForecast;
}
