package com.example.weather.service;

import com.example.weather.entity.Forecast;
import com.example.weather.entity.WeatherResponse;

import java.util.List;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    List<Forecast> getDataByCityNames(String cityNames);
}
