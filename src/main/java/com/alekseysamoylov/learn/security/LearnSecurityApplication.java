package com.alekseysamoylov.learn.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LearnSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSecurityApplication.class, args);
    }
}
