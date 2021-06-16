package com.myorganization.myservice.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MyServiceRestTemplateFactory {
    public RestTemplate create() {
        return new RestTemplateBuilder()
                .build();
    }
}