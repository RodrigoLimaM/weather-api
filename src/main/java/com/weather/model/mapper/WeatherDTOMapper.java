package com.weather.model.mapper;

import com.weather.model.HGForecastResponse;
import com.weather.model.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.WeatherForecast;
import com.weather.service.util.DateConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherDTOMapper {

    @Autowired
    DateConversionService dateConversionService;

    public WeatherDTO mapHGResponseToDTO(HGResultsResponse hgResultsResponse) {
        return WeatherDTO
                .builder()
                .currentTemperature(hgResultsResponse.getTemp())
                .descripton(hgResultsResponse.getDescription())
                .weatherForecast(mapHGForecastListResponseToDTO(hgResultsResponse.getForecast()))
                .build();
    }

    private List<WeatherForecast> mapHGForecastListResponseToDTO(List<HGForecastResponse> forecast) {
        return forecast
                .stream()
                .map(this::mapHGForecastResponseToDTO)
                .collect(Collectors.toList());
    }

    private WeatherForecast mapHGForecastResponseToDTO(HGForecastResponse forecast) {
        return WeatherForecast
                .builder()
                .max(forecast.getMax())
                .min(forecast.getMin())
                .date(dateConversionService.convertDate(forecast.getDate()))
                .description(forecast.getDescription())
                .build();
    }
}
