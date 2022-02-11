package com.example.weather.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Configuration
public class Config {
//    @Bean
//    public RestTemplate restTemplate(RestTemplateBuilder builder) {
//        // Do any additional configuration here
//        return builder.build();
//    }

//    @Bean
//    public RestTemplate restTemplate() {
//        RestTemplate restTemplate = new RestTemplate(new OkHttp3ClientHttpRequestFactory());
//        //消息转换器列表
//        List<HttpMessageConverter<?>> messageConverters = restTemplate.getMessageConverters();
//        //配置消息转换器StringHttpMessageConverter，并设置utf-8
//        messageConverters.set(1,
//                new StringHttpMessageConverter(StandardCharsets.UTF_8));//支持中文字符集，默认ISO-8859-1，支持utf-8
//
//        return restTemplate;
//    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate(new HttpComponentsClientHttpRequestFactory()); //Apache Httpclient
        restTemplate.getMessageConverters().set(1, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        return restTemplate;
    }
}
