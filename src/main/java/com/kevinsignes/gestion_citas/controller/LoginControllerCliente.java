package com.kevinsignes.gestion_citas.controller;



import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import com.kevinsignes.gestion_citas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Controller
public class LoginControllerCliente {
    @Autowired
    private  IUserRepository iUserRepository;


    @GetMapping({"/login"})
    public String goToLogin(Model model){
        return "login";
    }
    @PostMapping("/login")
    public String login(String username, String password, AuthenticationManager authManager){
        UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authResult = authManager.authenticate(authRequest);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return "redirect:/inicio";
    }


    @GetMapping("/informacion")
    public String verUsuarioActual(Authentication authentication, Model model) {
        String nombreUsuario = authentication.getName();
        Optional<UserEntity> usuario = Optional.ofNullable(iUserRepository.findByUsuario(nombreUsuario));

        usuario.ifPresent(u -> {
            model.addAttribute("usuario", u);
        });

        return "admin";
    }

}