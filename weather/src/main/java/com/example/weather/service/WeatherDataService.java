package com.example.weather.service;

import com.example.weather.entity.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
