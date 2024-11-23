package com.poo.cuidapcd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OlaMundoController {

    @GetMapping("/")
    public String OlaMundo(){
        return "Ola mundo teste";
    }
}
