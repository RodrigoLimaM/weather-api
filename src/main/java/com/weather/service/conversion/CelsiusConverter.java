package com.weather.service.conversion;

import com.weather.model.WeatherDTO;

class CelsiusConverter implements TemperatureConverter{

    @Override
    public WeatherDTO convert(WeatherDTO dto) {
        return dto;
    }
}
