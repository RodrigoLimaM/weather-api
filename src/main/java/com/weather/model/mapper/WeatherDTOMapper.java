package com.weather.model.mapper;

import com.weather.model.HGResponse;
import com.weather.model.HGResponse.HGForecastResponse;
import com.weather.model.HGResponse.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.WeatherDTO.WeatherForecast;
import com.weather.service.conversion.TemperatureType;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class WeatherDTOMapper {

    public WeatherDTO mapHGResponseToDTO(HGResultsResponse hgResultsResponse, String temperatureType) {
        return WeatherDTO
                .builder()
                .temperatureType(setTemperatureType(temperatureType))
                .currentTemperature(hgResultsResponse.getTemp())
                .description(hgResultsResponse.getDescription())
                .weatherForecast(mapHGForecastListResponseToDTO(hgResultsResponse.getForecast()))
                .build();
    }

    TemperatureType setTemperatureType(String temperatureType) {
        try {
            return TemperatureType.valueOf(temperatureType.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return TemperatureType.UNKNOWN;
        }
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
                .date(forecast.getDate())
                .description(forecast.getDescription())
                .build();
    }
}
