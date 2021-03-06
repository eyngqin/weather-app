package com.example.weather.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Forecast implements Serializable {
    private String city;
    private String date;
    private String high;
    private String fengxiang;
    private String low;
    private String fengli;
    private String type;
}
