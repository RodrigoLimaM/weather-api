package com.weather.service.conversion;

import com.weather.model.WeatherDTO;

import static com.weather.service.conversion.TemperatureType.KELVIN;

public class KelvinConverter implements TemperatureConverter{

    @Override
    public WeatherDTO convert(WeatherDTO dtoResponse) {
        dtoResponse.setTemperatureType(KELVIN);
        dtoResponse.setCurrentTemperature((int) (dtoResponse.getCurrentTemperature() + 273.15));
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMax((int) (forecast.getMax() + 273.15)));
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMin((int) (forecast.getMin() + 273.15)));

        return dtoResponse;
    }
}
