package com.alekseysamoylov.learn.security.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.alekseysamoylov.learn.security.model.ErrorJson;

import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
public class AppErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Value("${custom-error-controller.debug}")
    private boolean debug;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(value = PATH)
    ResponseEntity<ErrorJson> error(HttpServletRequest request, HttpServletResponse response) {
        return ResponseEntity.status(response.getStatus())
                .body(new ErrorJson(response.getStatus(), getErrorAttributes(request, debug)));
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }

    private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        WebRequest requestAttributes = new ServletWebRequest(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }

}
