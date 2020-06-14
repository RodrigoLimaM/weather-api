package com.weather.service;

import com.weather.client.HGClient;
import com.weather.exception.CityNameNotFoundException;
import com.weather.model.HGResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.mapper.WeatherDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    HGClient HGClient;

    @Autowired
    WeatherDTOMapper weatherDTOMapper;

    @Value("${hgbrasil-weather.key}")
    String apiKey;

    public WeatherDTO getWeatherData(String city) {
        var weatherResponse = HGClient.getHGWeather(apiKey, city);
        if(weatherResponse.getBy().equals("default"))
            throw new CityNameNotFoundException();
        return weatherDTOMapper.mapHGResponseToDTO(weatherResponse.getResults());
    }
}
