package com.weather.model.mapper;

import com.weather.model.HGResultsResponse;
import com.weather.model.WeatherDTO;
import com.weather.model.enums.TemperatureTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static com.weather.model.enums.TemperatureTypeEnum.CELSIUS;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WeatherDTOMapperTest {

    @Autowired
    WeatherDTOMapper weatherDTOMapper;

    @Test
    public void mapHGResponseToDTO() {
        WeatherDTO expect = WeatherDTO.builder().currentTemperature(30).description("Teste").temperatureType(CELSIUS).weatherForecast(new ArrayList<>()).build();

        HGResultsResponse actual = HGResultsResponse.builder().description("Teste").temp(30).forecast(new ArrayList<>()).build();
        assertEquals(expect, weatherDTOMapper.mapHGResponseToDTO(actual));
    }
}
