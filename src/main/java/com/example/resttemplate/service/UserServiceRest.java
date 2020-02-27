package com.example.resttemplate.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceRest {
    private final RestTemplate restTemplate;
    private String serverUrl = "http://localhost:8080";

    public UserServiceRest(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<?> getAllUsers() {
        return restTemplate.exchange(
                serverUrl + "/admin",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<?>>() {
                }
        ).getBody();
    }

    public Object addUser(Object user) {
        return restTemplate.postForObject(
                serverUrl + "/admin",
                user,
                Object.class
        );
    }

    public Object getUserById(String id) {
        Map<String, String> params = new HashMap<>();
        params.put("id", id);
        return restTemplate.getForObject(
                serverUrl + "/admin/" + id,
                Object.class,
                params
        );
    }

    public void updateUser(Object user) {
        restTemplate.put(
                serverUrl + "/admin/" + 1,
                user
        );
    }

    public void deleteUser(String id) {
        HashMap<String, String> params = new HashMap<>();
        params.put("id", id);

        restTemplate.delete(
                serverUrl,
                params
        );
    }
}
