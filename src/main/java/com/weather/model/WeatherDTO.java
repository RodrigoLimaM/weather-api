package com.weather.model;

import com.weather.service.conversion.TemperatureType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class WeatherDTO {

    @ApiModelProperty(example = "CELSIUS")
    private TemperatureType temperatureType;

    @ApiModelProperty(example = "31")
    private Integer currentTemperature;

    @ApiModelProperty(example = "Trovoadas dispersas")
    private String description;

    private List<WeatherForecast> weatherForecast;
}
