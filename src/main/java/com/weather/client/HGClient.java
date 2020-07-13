package com.weather.client;

import com.weather.model.HGResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(name = "HGClient", url = "${hgbrasil-weather.url}")
public interface HGClient {

    @GetMapping("/weather")
    Optional<HGResponse> getHGWeather(@RequestParam String key,
                                     @RequestParam String city_name);
}