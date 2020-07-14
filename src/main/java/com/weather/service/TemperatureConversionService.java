package com.weather.service;

import com.weather.model.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public class TemperatureConversionService {

    public WeatherDTO convert(WeatherDTO dto) {
        return dto.getTemperatureType().convert(dto);
    }

}
