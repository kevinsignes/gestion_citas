package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import com.kevinsignes.academia.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String goToservicio(Model model){
        model.addAttribute("cliente", new ClienteEntity());
        return "cliente";
    }
    @PostMapping("/cliente/submit")
    public String processServicio(@ModelAttribute("servicio") ClienteEntity cliente) {
        iClienteRepository.save(cliente);
        return "redirect:/inicio";
    }
    @GetMapping("/cliente/all")
    public String processServicioList(Model model) {
        List<ClienteEntity> clienteEntities = iClienteRepository.findAll();
        model.addAttribute("servicio",clienteEntities);
        return "clienteListado";
    }


}
