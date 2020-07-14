package com.weather.service;

import com.weather.client.HGClient;
import com.weather.exception.CityNameNotFoundException;
import com.weather.model.HGResponse;
import com.weather.model.HGResponse.HGResultsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HGService {

    @Autowired
    HGClient hgClient;

    public Optional<HGResultsResponse> getHGResults(String city) {
        return hgClient.getHGWeather(System.getenv("API_KEY"), city)
                .map(this::isValidCity);
    }

    private HGResultsResponse isValidCity(HGResponse hgResponse) {
        if(hgResponse.getBy().equals("default"))
            throw new CityNameNotFoundException();

        return hgResponse.getResults();
    }
}
