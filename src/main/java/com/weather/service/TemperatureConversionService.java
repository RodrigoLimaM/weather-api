package com.weather.service;

import com.weather.exception.TemperatureTypeBadRequestException;
import com.weather.model.WeatherDTO;
import com.weather.model.enums.TemperatureTypeEnum;
import org.springframework.stereotype.Service;

import static com.weather.model.enums.TemperatureTypeEnum.CELSIUS;
import static com.weather.model.enums.TemperatureTypeEnum.FAHRENHEIT;
import static com.weather.model.enums.TemperatureTypeEnum.KELVIN;

@Service
public class TemperatureConversionService {

    public WeatherDTO convert(WeatherDTO dtoResponse, TemperatureTypeEnum temperatureType) {

        switch (temperatureType) {
            case FAHRENHEIT:
                return convertToFahrenheit(dtoResponse);
            case KELVIN:
                return convertToKelvin(dtoResponse);
            case CELSIUS:
                return convertToCelsius(dtoResponse);
            default:
                throw new TemperatureTypeBadRequestException();
        }
    }

    private WeatherDTO convertToFahrenheit(WeatherDTO dtoResponse) {
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

    private WeatherDTO convertToKelvin(WeatherDTO dtoResponse) {
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

    private WeatherDTO convertToCelsius(WeatherDTO dtoResponse) {
        dtoResponse.setTemperatureType(CELSIUS);

        return dtoResponse;
    }
}
