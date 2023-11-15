package com.kevinsignes.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Agente {


    @GetMapping({"/login"})
    public String goToLogin(){
        return "login";
    }



}
