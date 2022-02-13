package com.example.weather.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class WeatherResponse implements Serializable {
    private Weather data;
    private String status;
    private String desc;
}
