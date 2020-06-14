package com.weather.model.mapper;

import com.weather.model.HGForecastResponse;
import com.weather.model.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.WeatherForecast;
import com.weather.util.DateConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherDTOMapper {

    @Autowired
    DateConversion dateConversion;

    public WeatherDTO mapHGResponseToDTO(HGResultsResponse hgResultsResponse) {
        return WeatherDTO
                .builder()
                .currentTemperature(hgResultsResponse.getTemp())
                .description(hgResultsResponse.getDescription())
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
                .date(dateConversion.convertDate(forecast.getDate()))
                .description(forecast.getDescription())
                .build();
    }
}
