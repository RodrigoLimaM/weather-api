package com.weather.model.mapper;

import com.weather.model.HGResponse;
import com.weather.model.HGResponse.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.service.conversion.TemperatureType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static com.weather.service.conversion.TemperatureType.CELSIUS;
import static com.weather.service.conversion.TemperatureType.FAHRENHEIT;
import static com.weather.service.conversion.TemperatureType.KELVIN;
import static com.weather.service.conversion.TemperatureType.UNKNOWN;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherDTOMapperTest {

    @Autowired
    WeatherDTOMapper weatherDTOMapper;

    @Test
    public void shouldReturnWeatherDTO(){
        WeatherDTO expected = WeatherDTO.builder()
                .weatherForecast(Collections.emptyList())
                .currentTemperature(30)
                .description("teste")
                .temperatureType(CELSIUS)
                .build();

        HGResultsResponse hgResultsResponse = HGResultsResponse
                .builder()
                .forecast(Collections.emptyList())
                .temp(30)
                .description("teste")
                .build();

        WeatherDTO actual = weatherDTOMapper.mapHGResponseToDTO(hgResultsResponse, "celsius");

        assertEquals(expected, actual);
    }

    @Test
    public void whenTemperatureTypeIsCelsius_thenShouldReturnCelsius(){

        TemperatureType actual = weatherDTOMapper.setTemperatureType("celsius");

        assertEquals(CELSIUS, actual);
    }

    @Test
    public void whenTemperatureTypeIsKelvin_thenShouldReturnKelvin(){

        TemperatureType actual = weatherDTOMapper.setTemperatureType("kelvin");

        assertEquals(KELVIN, actual);
    }

    @Test
    public void whenTemperatureTypeIsFahrenheit_thenShouldReturnFahrenheit(){

        TemperatureType actual = weatherDTOMapper.setTemperatureType("fahrenheit");

        assertEquals(FAHRENHEIT, actual);
    }

    @Test
    public void whenTemperatureTypeIsUnknown_thenShouldReturnUnknown(){

        TemperatureType actual = weatherDTOMapper.setTemperatureType("teste");

        assertEquals(UNKNOWN, actual);
    }
}
