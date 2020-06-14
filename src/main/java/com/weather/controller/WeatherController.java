package com.weather.controller;

import com.weather.model.WeatherDTO;
import com.weather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping
    public ResponseEntity<WeatherDTO> getWeatherData
            (@RequestParam String city,
             @RequestParam(defaultValue = "celsius", required = false) String temperatureType){
        return ResponseEntity.ok().body(weatherService.getWeatherData(city, temperatureType));
    }
}
