package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.Usuario;
import com.kevinsignes.academia.repository.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {
    @Autowired
    private IUsuarioRepository iUserRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping({"/register"})
    public String goToregister(Model model){
        model.addAttribute("user", new Usuario());
        return "register";
    }
    @PostMapping("/register/submit")
    public String processRegister(@ModelAttribute("user") Usuario user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        iUserRepository.save(user);
        return "index";
    }
}