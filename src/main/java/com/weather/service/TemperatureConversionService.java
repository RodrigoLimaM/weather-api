package com.weather.service;

import com.weather.model.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public class TemperatureConversionService {

    public WeatherDTO convert(WeatherDTO dtoResponse) {
        return dtoResponse.getTemperatureType().convert(dtoResponse);
    }

}
