package com.weather.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeatherDTO {

    @ApiModelProperty(example = "celsius")
    private String temperatureType;

    @ApiModelProperty(example = "31")
    private Integer currentTemperature;

    @ApiModelProperty(example = "Trovoadas dispersas")
    private String description;

    private List<WeatherForecast> weatherForecast;
}
