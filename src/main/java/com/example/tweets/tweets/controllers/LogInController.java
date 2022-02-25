package com.example.tweets.tweets.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogInController {

    @GetMapping(value = "/")
    @ResponseStatus(value = HttpStatus.OK)
    public String hello(Model model) {
        String response = "hello";
        model.addAttribute("helloName", response);
        return "home";
    }
}
