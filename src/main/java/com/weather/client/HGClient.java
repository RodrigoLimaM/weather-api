package com.weather.client;

import com.weather.model.HGResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "HGClient", url = "${hgbrasil-weather.url}")
public interface HGClient {

    @GetMapping("/weather")
    HGResponse getHGWeather(@RequestParam String key,
                            @RequestParam String city_name);
}
