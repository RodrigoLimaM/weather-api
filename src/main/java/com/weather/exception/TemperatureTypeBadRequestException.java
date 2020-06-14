package com.weather.exception;

public class TemperatureTypeBadRequestException extends RuntimeException{
    public TemperatureTypeBadRequestException() {
        super("Invalid temperature type");
    }
}
