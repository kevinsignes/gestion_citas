package com.kevinsignes.academia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class Agente {

    @GetMapping("/")
    public String indice(){
        return "pagina";
    }

    @GetMapping("/asignaturas")
    public String asignatura(){

        return "asignaturas";
    }

    @GetMapping("/notas")
    public String notas(){

        return "notas";
    }

    @GetMapping("/perfil")
    public String perfil(){

        return "perfil";
    }

    @RequestMapping("/login")
    public String login(Model model) {
            model.addAttribute("error", "Credenciales inválidas");
            model.addAttribute("message", "Ha cerrado sesión con éxito");

        return "login";
    }



}
