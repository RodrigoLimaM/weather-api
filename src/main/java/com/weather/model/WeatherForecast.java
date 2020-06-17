package com.weather.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WeatherForecast {

    @ApiModelProperty(example = "18/06")
    private String date;

    @ApiModelProperty(example = "30")
    private Integer max;

    @ApiModelProperty(example = "22")
    private Integer min;

    @ApiModelProperty(example = "Tempestades")
    private String description;
}
