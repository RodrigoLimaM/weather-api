package com.weather.service.conversion;

import com.weather.model.WeatherDTO;

import static com.weather.service.conversion.TemperatureType.FAHRENHEIT;

public class FahrenheitConverter implements TemperatureConverter{

    @Override
    public WeatherDTO convert(WeatherDTO dtoResponse) {
        dtoResponse.setTemperatureType(FAHRENHEIT);
        dtoResponse.setCurrentTemperature(dtoResponse.getCurrentTemperature() * 9/5 + 32);
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMax(forecast.getMax() * 9/5 + 32));
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMin(forecast.getMin() * 9/5 + 32));

        return dtoResponse;
    }
}
