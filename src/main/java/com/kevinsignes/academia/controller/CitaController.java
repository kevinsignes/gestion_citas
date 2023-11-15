package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.AgendaEntity;
import com.kevinsignes.academia.basededatos.CitaEntity;
import com.kevinsignes.academia.repository.IAgendaRepository;
import com.kevinsignes.academia.repository.ICitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CitaController {

    @Autowired
    private ICitaRepository iCitaRepository;

    @GetMapping({"/cita"})
    public String goTocita(Model model){
        model.addAttribute("cita", new AgendaEntity());
        return "cita";
    }
    @PostMapping("/cita/submit")
    public String processCita(@ModelAttribute("cita") CitaEntity cita) {
        iCitaRepository.save(cita);
        return "redirect:/cita/all";
    }
    @GetMapping("/cita/all")
    public String processCitaList(Model model) {
        List<CitaEntity> citaEntities = iCitaRepository.findAll();
        model.addAttribute("cita",citaEntities);
        return "citaListado";
    }
}
