package com.alekseysamoylov.learn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping({"/", "/admin", "/registration"})
    public String index() {
        return "index";
    }

}
