package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.ClienteEntity;
import com.kevinsignes.gestion_citas.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class ClienteController {


    @Autowired
    private IClienteRepository iClienteRepository;

    @GetMapping({"/cliente"})
    public String goTocliente(Model model){
        model.addAttribute("cliente", new ClienteEntity());
        return "cliente";
    }
    @PostMapping("/cliente/submit")
    public String processRegisterCliente(ClienteEntity cliente) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(cliente.getPassword());
        cliente.setPassword(encodedPassword);
        iClienteRepository.save(cliente);
        return "redirect:/inicio";
    }
    @GetMapping("/cliente/all")
    public String processClienteList(Model model) {
        List<ClienteEntity> clienteEntities = iClienteRepository.findAll();
        model.addAttribute("cliente",clienteEntities);
        return "clienteListado";
    }


}
