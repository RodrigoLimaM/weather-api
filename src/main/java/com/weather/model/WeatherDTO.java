package com.weather.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeatherDTO {

    public Integer currentTemperature;

    public String descripton;

    public List<WeatherForecast> weatherForecast;
}
