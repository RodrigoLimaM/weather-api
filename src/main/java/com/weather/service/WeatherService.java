package com.weather.service;

import com.weather.client.HGClient;
import com.weather.exception.CityNameNotFoundException;
import com.weather.model.WeatherDTO;
import com.weather.model.mapper.WeatherDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WeatherService {

    @Autowired
    HGClient hgClient;

    @Autowired
    WeatherDTOMapper weatherDTOMapper;

    @Autowired
    TemperatureConversionService temperatureConversionService;

    @Value("${hgbrasil-weather.key}")
    String apiKey;

    public WeatherDTO getWeatherData(String city, String temperatureType) {
        var hgResponse = hgClient.getHGWeather(apiKey, city);

        if(hgResponse.getBy().equals("default"))
            throw new CityNameNotFoundException();

        var dtoResponse = weatherDTOMapper.mapHGResponseToDTO(hgResponse.getResults());

        dtoResponse = temperatureConversionService.convert(dtoResponse, temperatureType);

        return dtoResponse;
    }

}
