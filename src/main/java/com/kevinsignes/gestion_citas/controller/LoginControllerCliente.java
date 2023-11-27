package com.kevinsignes.gestion_citas.controller;


import com.kevinsignes.gestion_citas.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControllerCliente {
    @Autowired
    private IClienteRepository iClienteRepository;

    @GetMapping({"/login"})
    public String goToLogin(Model model){
        return "login";
    }

}