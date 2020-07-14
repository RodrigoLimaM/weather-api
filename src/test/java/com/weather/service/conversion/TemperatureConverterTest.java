package com.weather.service.conversion;

import com.weather.exception.UnknownTemperatureTypeException;
import com.weather.model.WeatherDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;

import static com.weather.service.conversion.TemperatureType.CELSIUS;
import static com.weather.service.conversion.TemperatureType.FAHRENHEIT;
import static com.weather.service.conversion.TemperatureType.KELVIN;
import static com.weather.service.conversion.TemperatureType.UNKNOWN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class TemperatureConverterTest {

    private WeatherDTO expectedWeatherDTO;

    private WeatherDTO actualWeatherDTO;

    @BeforeEach
    public void setup(){
        expectedWeatherDTO = weatherDTOBuider();
        actualWeatherDTO = weatherDTOBuider();
    }

    private WeatherDTO weatherDTOBuider() {
        return WeatherDTO.builder()
                .weatherForecast(Collections.emptyList())
                .currentTemperature(30)
                .description("teste")
                .temperatureType(CELSIUS)
                .build();
    }

    @Test
    public void whenIsCelsius_ThenShouldReturnDto(){
        WeatherDTO expected = expectedWeatherDTO;

        WeatherDTO actual = CELSIUS.convert(expected);

        assertEquals(expected, actual);
    }

    @Test
    public void whenIsKelvin_ThenShouldReturnKelvin(){
        WeatherDTO expected = expectedWeatherDTO;
        expectedWeatherDTO.setTemperatureType(KELVIN);
        expectedWeatherDTO.setCurrentTemperature(303);

        WeatherDTO actual = KELVIN.convert(actualWeatherDTO);

        assertEquals(expected, actual);
    }

    @Test
    public void whenIsFahrenheit_ThenShouldReturnFahrenheit(){
        WeatherDTO expected = expectedWeatherDTO;
        expectedWeatherDTO.setTemperatureType(FAHRENHEIT);
        expectedWeatherDTO.setCurrentTemperature(86);

        WeatherDTO actual = FAHRENHEIT.convert(actualWeatherDTO);

        assertEquals(expected, actual);
    }

    @Test
    public void whenIsUnknown_ThenShouldThrowUnknownTemperatureTypeException(){
        assertThrows(UnknownTemperatureTypeException.class,
                () -> UNKNOWN.convert(actualWeatherDTO));
    }
}
