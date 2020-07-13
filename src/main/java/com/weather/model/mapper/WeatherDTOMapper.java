package com.weather.model.mapper;

import com.weather.model.HGForecastResponse;
import com.weather.model.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.WeatherForecast;
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

    private TemperatureType setTemperatureType(String temperatureType) {
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
