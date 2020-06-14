package com.weather.client;

import com.weather.model.response.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "WeatherClient", url = "${hgbrasil-weather.url}")
public interface WeatherClient {

    @GetMapping("/weather")
    WeatherResponse getWeather(@RequestParam String key,
                              @RequestParam String city_name);
}
