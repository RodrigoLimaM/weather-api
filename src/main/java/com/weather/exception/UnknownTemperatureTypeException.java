package com.weather.exception;

public class UnknownTemperatureTypeException extends RuntimeException{

    public UnknownTemperatureTypeException() {
        super("Invalid temperature type");
    }
}
