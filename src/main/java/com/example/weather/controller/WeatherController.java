package com.example.weather.controller;

import com.example.weather.entity.Forecast;
import com.example.weather.entity.WeatherResponse;
import com.example.weather.service.WeatherDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
        return weatherDataService.getDataByCityName(cityName);
    }

    @GetMapping("/cityNames/{cityNames}")
    public List<Forecast> getReportByCityNames(@PathVariable("cityNames") String cityNames) {
        return weatherDataService.getDataByCityNames(cityNames);
    }


}
