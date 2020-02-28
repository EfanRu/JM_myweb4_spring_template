package com.example.resttemplate.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class LoginController {
    private String url = "http://localhost:8080/";

    @GetMapping({"/", "/login"})
    public ResponseEntity<String> login() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response;
    }


//    @GetMapping("/authorization")
//    public ResponseEntity<String> authorization() {
//        RestTemplate restTemplate = new RestTemplate();
//        return restTemplate.getForEntity(url, String.class);
//    }


    @GetMapping("/authorization")
    public ResponseEntity<String> authorization(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("login", "admin");
        map.add("password", "admin");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return restTemplate.postForEntity( url, request , String.class );
    }
}
