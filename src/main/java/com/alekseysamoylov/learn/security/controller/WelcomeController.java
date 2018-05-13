package com.alekseysamoylov.learn.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class WelcomeController {

    @GetMapping({"/", "/admin", "login", "/registration"})
    public String index() {
        return "index";
    }

}
