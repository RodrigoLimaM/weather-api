package com.weather.service.conversion;

import com.weather.exception.UnknownTemperatureTypeException;
import com.weather.model.WeatherDTO;

public class UnknownConverter implements TemperatureConverter{

    @Override
    public WeatherDTO convert(WeatherDTO dto) {
        throw new UnknownTemperatureTypeException();
    }
}
