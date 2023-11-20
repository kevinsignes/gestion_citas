package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.ServicioEntity;
import com.kevinsignes.academia.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public String processServicio(@ModelAttribute("servicio") ServicioEntity servicio) {
        iServicioRepository.save(servicio);
        return "redirect:/inicio";
    }
    @GetMapping("/inicio")
    public String processServicioList(Model model) {
        List<ServicioEntity> servicioEntities = iServicioRepository.findAll();
        model.addAttribute("servicio",servicioEntities);
        return "inicio";
    }

    @RequestMapping ("/editar/{id}")
    public String editarServicio(@PathVariable int id, Model modelo){

        modelo.addAttribute("servicio",
                iServicioRepository.findById(id).get());
        return "editar_servicio";
    }

    @PostMapping ("/actualizar")
    public String actualizaServicio(@ModelAttribute("servicio") ServicioEntity servicioEntity){
        iServicioRepository.save(servicioEntity);
        return "redirect:/inicio";
    }

    @GetMapping ("/borrar/{id}")
    public String borrarServicio(@PathVariable int id){
        iServicioRepository.deleteById(id);
        return "redirect:/inicio";
    }

}
