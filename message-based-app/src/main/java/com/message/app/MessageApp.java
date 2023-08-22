package com.message.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MessageApp {
    public static void main(String[] args) {

        SpringApplication.run(MessageApp.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}