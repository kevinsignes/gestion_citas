package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.ClienteEntity;
import com.kevinsignes.academia.basededatos.ServicioEntity;
import com.kevinsignes.academia.repository.IClienteRepository;
import com.kevinsignes.academia.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ServicioController {

    @Autowired
    private IServicioRepository iServicioRepository;

    @GetMapping({"/servicio"})
    public String goToservicio(Model model){
        model.addAttribute("servicio", new ServicioEntity());
        return "servicio";
    }
    @PostMapping("/servicio/submit")
    public String processAsignatura(@ModelAttribute("servicio") ServicioEntity servicio) {
        iServicioRepository.save(servicio);
        return "redirect:/servicio/all";
    }
    @GetMapping("/servicio/all")
    public String processAsignaturaList(Model model) {
        List<ServicioEntity> servicioEntities = iServicioRepository.findAll();
        model.addAttribute("servicio",servicioEntities);
        return "servicioListado";
    }
}
