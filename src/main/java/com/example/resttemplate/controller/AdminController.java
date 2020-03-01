package com.example.resttemplate.controller;

import com.example.resttemplate.model.User;
import com.example.resttemplate.service.UserServiceRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

//    private UserServiceRest userService;
    private String url = "http://localhost:8080/";


//    @Autowired
//    private void setUserService(UserServiceRest userService) {
//        this.userService = userService;
//    }

    @GetMapping("/admin")
    public ResponseEntity<User> authorization() {
        return new RestTemplate().getForEntity(url, User.class);
    }

}
