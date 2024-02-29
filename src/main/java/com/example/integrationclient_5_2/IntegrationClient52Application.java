package com.example.integrationclient_5_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class IntegrationClient52Application {

    public static void main(String[] args) {
        SpringApplication.run(IntegrationClient52Application.class, args);
    }

}
