package com.weather.service;

import com.weather.model.WeatherDTO;
import com.weather.model.enums.TemperatureTypeEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static com.weather.model.enums.TemperatureTypeEnum.FAHRENHEIT;
import static com.weather.model.enums.TemperatureTypeEnum.KELVIN;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TemperatureConversionServiceTest {

    @Autowired
    TemperatureConversionService temperatureConversionService;

    @Test
    public void convert(){
        WeatherDTO expectedFahrenheit = WeatherDTO.builder().currentTemperature(86).description("Teste").temperatureType(FAHRENHEIT).weatherForecast(new ArrayList<>()).build();

        WeatherDTO actualFahrenheit = WeatherDTO.builder().currentTemperature(30).description("Teste").temperatureType(FAHRENHEIT).weatherForecast(new ArrayList<>()).build();

        WeatherDTO expectedKelvin = WeatherDTO.builder().currentTemperature(303).description("Teste").temperatureType(KELVIN).weatherForecast(new ArrayList<>()).build();

        WeatherDTO actualKelvin = WeatherDTO.builder().currentTemperature(30).description("Teste").temperatureType(KELVIN).weatherForecast(new ArrayList<>()).build();

        assertEquals(expectedFahrenheit, temperatureConversionService.convert(actualFahrenheit, FAHRENHEIT));
        assertEquals(expectedKelvin, temperatureConversionService.convert(actualKelvin, KELVIN));

    }
}
