package com.weather.service;

import com.weather.client.WeatherClient;
import com.weather.exception.CityNameNotFoundException;
import com.weather.model.response.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    WeatherClient weatherClient;

    @Value("${hgbrasil-weather.key}")
    String apiKey;

    public WeatherResponse getWeatherData(String city) {
        var weatherResponse = weatherClient.getWeather(apiKey, city);
        if(weatherResponse.getBy().equals("default"))
            throw new CityNameNotFoundException();
        return weatherResponse;
    }
}
