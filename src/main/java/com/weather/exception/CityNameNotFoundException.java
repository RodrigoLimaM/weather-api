package com.weather.exception;

public class CityNameNotFoundException extends RuntimeException{

    public CityNameNotFoundException(){
        super("City name not found");
    }
}
