package com.weather.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class WeatherForecast {

    @ApiModelProperty(example = "2020-06-14")
    private LocalDate date;

    @ApiModelProperty(example = "30")
    private Integer max;

    @ApiModelProperty(example = "22")
    private Integer min;

    @ApiModelProperty(example = "Tempestades")
    private String description;
}
