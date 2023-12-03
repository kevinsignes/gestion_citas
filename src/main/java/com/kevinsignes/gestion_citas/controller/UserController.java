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
    private IUserRepository iClienteRepository;

    @GetMapping({"/cliente"})
    public String goTocliente(Model model){
        model.addAttribute("cliente", new UserEntity());
        return "cliente";
    }
    @PostMapping("/cliente/submit")
    public String processRegisterCliente(UserEntity user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        iClienteRepository.save(user);
        return "redirect:/inicio";
    }
    @GetMapping("/cliente/all")
    public String processClienteList(Model model) {
        List<UserEntity> clienteEntities = iClienteRepository.findAll();
        model.addAttribute("cliente",clienteEntities);
        return "clienteListado";
    }


}
