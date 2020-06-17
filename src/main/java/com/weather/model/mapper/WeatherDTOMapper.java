package com.weather.model.mapper;

import com.weather.model.HGForecastResponse;
import com.weather.model.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.WeatherForecast;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static com.weather.model.enums.TemperatureTypeEnum.CELSIUS;

@Component
public class WeatherDTOMapper {

    public WeatherDTO mapHGResponseToDTO(HGResultsResponse hgResultsResponse) {
        return WeatherDTO
                .builder()
                .temperatureType(CELSIUS)
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
                .date(forecast.getDate())
                .description(forecast.getDescription())
                .build();
    }
}
