package com.kevinsignes.gestion_citas.controller;


import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import com.kevinsignes.gestion_citas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class UserController {


    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping({"/crear_user"})
    public String goToUser(Model model){
        model.addAttribute("user", new UserEntity());
        return "crear_user";
    }
    @PostMapping("/user/submit")
    public String processRegisterUser(UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        iUserRepository.save(user);
        return "redirect:/inicio";
    }


    @GetMapping("/user/all")
    public String processClienteList(Model model) {
        List<UserEntity> clienteEntities = iUserRepository.findAll();
        model.addAttribute("user",clienteEntities);
        return "clienteListado";
    }


}
