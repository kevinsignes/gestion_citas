package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import com.kevinsignes.gestion_citas.repository.ICitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CitaController {

    @Autowired
    private ICitaRepository iCitaRepository;

    @GetMapping({"/cita"})
    public String goTocita(Model model){
        model.addAttribute("cita", new CitaEntity());
        return "cita";
    }
    @PostMapping("/cita/submit")
    public String processCita(@ModelAttribute("cita") CitaEntity cita) {
        iCitaRepository.save(cita);
        return "redirect:/mis_citas";
    }
    @GetMapping("/mis_citas")
    public String processCitaList(Model model) {
        List<CitaEntity> citaEntities = iCitaRepository.findAll();
        model.addAttribute("cita",citaEntities);
        return "mis_citas";
    }
    @RequestMapping("/cita/editar/{id}")
    public String editarServicio(@PathVariable int id, Model modelo){

        modelo.addAttribute("cita",
                iCitaRepository.findById(id).get());
        return "editar_cita";
    }


    @PostMapping ("/cita/actualizar")
    public String actualizaCita(@ModelAttribute("servicio") CitaEntity citaEntity){
        iCitaRepository.save(citaEntity);
        return "redirect:/mis_citas";
    }

    @GetMapping ("/cita/borrar/{id}")
    public String borrarCita(@PathVariable int id){
        iCitaRepository.deleteById(id);
        return "redirect:/mis_citas";
    }
}
