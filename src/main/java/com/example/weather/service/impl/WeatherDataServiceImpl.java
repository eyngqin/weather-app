package com.example.weather.service.impl;

import com.example.weather.entity.Forecast;
import com.example.weather.entity.WeatherResponse;
import com.example.weather.service.WeatherDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.http.parser.MediaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${weather.api.cityid}")
    private String WEATHER_API_CITYID;
    @Value("${weather.api.cityname}")
    private String WEATHER_API_CITYNAME;


    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_API_CITYID + cityId;
        return this.doGetWeatherData(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_API_CITYNAME + cityName;
        return this.doGetWeatherData(uri);
    }

    @Override
    public List<Forecast> getDataByCityNames(String cityNames) {
        String[] citys = cityNames.split(",");
        List<Forecast> list = new ArrayList<Forecast>();
        for (String cityName: citys) {
            Forecast f = this.doGetWeatherData(WEATHER_API_CITYNAME + cityName)
                    .getData().getForecast().get(0);
            f.setCity(cityName);
            list.add(f);
        }
        return list;
    }

    private WeatherResponse doGetWeatherData(String uri) {

        String strBody = null;

        ResponseEntity<String> response = restTemplate.getForEntity(uri, String.class);
        if (response.getStatusCodeValue() == 200) {
            strBody = response.getBody();
        }
        ObjectMapper mapper = new ObjectMapper();
        WeatherResponse weather = null;
        try {
            weather = mapper.readValue(strBody, WeatherResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
