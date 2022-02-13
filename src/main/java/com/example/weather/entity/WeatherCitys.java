package com.example.weather.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class WeatherCitys implements Serializable {

    private String city;
    private String updateTime;
    private String weather;
    private String temperature;
    private String wind;
}
