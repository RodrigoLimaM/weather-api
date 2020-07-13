package com.weather.service.conversion;

import com.weather.model.WeatherDTO;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TemperatureType {
    CELSIUS(new CelsiusConverter()),
    FAHRENHEIT(new FahrenheitConverter()),
    KELVIN(new KelvinConverter()),
    UNKNOWN(new UnknownConverter());

    private final TemperatureConverter temperatureConverter;

    public WeatherDTO convert(WeatherDTO dto) {
        return temperatureConverter.convert(dto);
    }
}
