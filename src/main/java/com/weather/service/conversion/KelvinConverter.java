package com.weather.service.conversion;

import com.weather.model.WeatherDTO;

import static com.weather.service.conversion.TemperatureType.KELVIN;

class KelvinConverter implements TemperatureConverter{

    @Override
    public WeatherDTO convert(WeatherDTO dto) {
        dto.setTemperatureType(KELVIN);
        dto.setCurrentTemperature((int) (dto.getCurrentTemperature() + 273.15));
        dto.getWeatherForecast()
                .forEach(forecast -> forecast.setMax((int) (forecast.getMax() + 273.15)));
        dto.getWeatherForecast()
                .forEach(forecast -> forecast.setMin((int) (forecast.getMin() + 273.15)));

        return dto;
    }
}
