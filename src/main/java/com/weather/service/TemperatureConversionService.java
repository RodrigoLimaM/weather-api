package com.weather.service;

import com.weather.exception.TemperatureTypeBadRequestException;
import com.weather.model.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public class TemperatureConversionService {

    public WeatherDTO convert(WeatherDTO dtoResponse, String temperatureType) {

        switch (temperatureType) {
            case "fahrenheit":
                return convertToFahrenheit(dtoResponse);
            case "kelvin":
                return convertToKelvin(dtoResponse);
            case "celsius":
                return convertToCelsius(dtoResponse);
            default:
                throw new TemperatureTypeBadRequestException();
        }
    }

    private WeatherDTO convertToFahrenheit(WeatherDTO dtoResponse) {
        dtoResponse.setTemperatureType("fahrenheit");
        dtoResponse.setCurrentTemperature(dtoResponse.getCurrentTemperature() * 9/5 + 32);
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMax(forecast.getMax() * 9/5 + 32));
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMin(forecast.getMin() * 9/5 + 32));

        return dtoResponse;
    }

    private WeatherDTO convertToKelvin(WeatherDTO dtoResponse) {
        dtoResponse.setTemperatureType("kelvin");
        dtoResponse.setCurrentTemperature((int) (dtoResponse.getCurrentTemperature() + 273.15));
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMax((int) (forecast.getMax() + 273.15)));
        dtoResponse
                .getWeatherForecast()
                .forEach(forecast -> forecast.setMin((int) (forecast.getMin() + 273.15)));

        return  dtoResponse;
    }

    private WeatherDTO convertToCelsius(WeatherDTO dtoResponse) {
        dtoResponse.setTemperatureType("celsius");

        return dtoResponse;
    }
}
