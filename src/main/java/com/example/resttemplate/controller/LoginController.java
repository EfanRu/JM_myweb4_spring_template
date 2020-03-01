package com.example.resttemplate.controller;

import com.example.resttemplate.model.User;
import org.apache.commons.codec.binary.Base64;
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

import java.nio.charset.Charset;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class LoginController {
    private String url = "http://localhost:8080/";

    @GetMapping({"/", "/login"})
    public ResponseEntity<String> login() {
        return new RestTemplate().getForEntity(url, String.class);
    }

    @GetMapping("/error")
    public ResponseEntity<String> error() {
        return new RestTemplate().getForEntity(url, String.class);
    }


    @PostMapping("/authorization")
    public ResponseEntity<String> authorization(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();


//        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
//        map.add("login", "admin");
//        map.add("password", "admin");
//
//        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        return restTemplate.postForEntity( url, new HttpEntity<String>(createHeaders("admin", "admin")) , String.class );
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}
