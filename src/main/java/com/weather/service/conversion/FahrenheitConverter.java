package com.weather.service.conversion;

import com.weather.model.WeatherDTO;

import static com.weather.service.conversion.TemperatureType.FAHRENHEIT;

class FahrenheitConverter implements TemperatureConverter{

    @Override
    public WeatherDTO convert(WeatherDTO dto) {
        dto.setTemperatureType(FAHRENHEIT);
        dto.setCurrentTemperature(dto.getCurrentTemperature() * 9/5 + 32);
        dto.getWeatherForecast()
                .forEach(forecast -> forecast.setMax(forecast.getMax() * 9/5 + 32));
        dto.getWeatherForecast()
                .forEach(forecast -> forecast.setMin(forecast.getMin() * 9/5 + 32));

        return dto;
    }
}
