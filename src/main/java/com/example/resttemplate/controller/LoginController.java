package com.example.resttemplate.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {
    private String url = "http://localhost:8080/";

    @GetMapping({"/", "/login"})
    public ResponseEntity<String> login() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }


    @GetMapping("/authorization")
    public ResponseEntity<String> authorization() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url, String.class);
    }
}
