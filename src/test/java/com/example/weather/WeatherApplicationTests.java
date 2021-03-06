package com.example.weather;

import com.example.weather.entity.Forecast;
import com.example.weather.entity.WeatherResponse;
import com.example.weather.service.WeatherDataService;


//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherApplicationTests {

    @Autowired
    public WeatherDataService weatherDataService;

    @Test
    public void getDataByCityName() {

        String cityName = "北京";
        WeatherResponse weatherResponse = weatherDataService.getDataByCityName(cityName);

        assertEquals(cityName, weatherResponse.getData().getCity());
    }


    @Test
    public void getDataByCityId() {

        String cityId = "101280601";
        String cityName = "深圳";
        WeatherResponse weatherResponse = weatherDataService.getDataByCityId(cityId);

        assertEquals(cityName, weatherResponse.getData().getCity());
    }


    @Test
    public void getDataByCityNames() {

        String cityName = "北京,上海";
        List<Forecast> list = weatherDataService.getDataByCityNames(cityName);

        assertEquals(cityName.split(",")[0], list.get(0).getCity());
    }


}
