package com.weather.service;

import com.weather.model.WeatherDTO;
import com.weather.model.mapper.WeatherDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    HGService hgService;

    @Autowired
    WeatherDTOMapper weatherDTOMapper;

    @Autowired
    TemperatureConversionService temperatureConversionService;

    public Optional<WeatherDTO> getWeatherData(String city, String temperatureType) {

        return hgService.getHGResults(city)
                .map(hgResultsResponse -> weatherDTOMapper.mapHGResponseToDTO(hgResultsResponse, temperatureType))
                .map(temperatureConversionService::convert);
    }

}
