package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.UsuarioEntity;
import com.kevinsignes.academia.repositorys.IUsuarioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Agente {
    public IUsuarioRepository userrepo;
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



}
