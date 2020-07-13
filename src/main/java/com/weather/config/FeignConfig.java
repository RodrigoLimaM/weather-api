package com.weather.config;

import feign.Logger.Level;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    Level feignLoggerLevel() {
        return Level.FULL;
    }
}
