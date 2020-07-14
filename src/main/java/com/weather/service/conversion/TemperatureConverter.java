package com.weather.service.conversion;

import com.weather.model.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
interface TemperatureConverter {

    WeatherDTO convert(WeatherDTO dto);
}
