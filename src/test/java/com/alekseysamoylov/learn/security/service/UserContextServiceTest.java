package com.alekseysamoylov.learn.security.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserContextServiceTest {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("secret"));
    }

}
