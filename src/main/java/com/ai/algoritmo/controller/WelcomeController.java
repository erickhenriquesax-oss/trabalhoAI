package com.ai.algoritmo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class WelcomeController {
    @GetMapping
    public String welcomeController(){
        return "olá";
    }
}
