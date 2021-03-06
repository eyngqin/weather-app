package com.example.weather.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Weather implements Serializable {
    private String city;
    private String aqi;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
}
