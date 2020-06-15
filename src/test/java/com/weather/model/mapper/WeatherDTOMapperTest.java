package com.weather.model.mapper;

import com.weather.model.HGResultsResponse;
import com.weather.model.WeatherDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherDTOMapperTest {

    @Autowired
    WeatherDTOMapper weatherDTOMapper;

    @Test
    public void mapHGResponseToDTO() {
        var expect = WeatherDTO.builder().currentTemperature(30).description("Teste").temperatureType("celsius").weatherForecast(new ArrayList<>()).build();

        var actual = HGResultsResponse.builder().description("Teste").temp(30).forecast(new ArrayList<>()).build();
        assertEquals(expect, weatherDTOMapper.mapHGResponseToDTO(actual));
    }
}
