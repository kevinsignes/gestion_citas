package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.AgendaEntity;
import com.kevinsignes.gestion_citas.repository.IAgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AgendaController {



    @Autowired
    private IAgendaRepository iAgendaRepository;

    @GetMapping({"/agenda"})
    public String goTocurso(Model model){
        model.addAttribute("agenda", new AgendaEntity());
        return "agenda";
    }
    @PostMapping("/agenda/submit")
    public String processAgenda(@ModelAttribute("agenda") AgendaEntity agenda) {
        iAgendaRepository.save(agenda);
        return "redirect:/agenda/all";
    }
    @GetMapping("/agenda/all")
    public String processAgendaList(Model model) {
        List<AgendaEntity> agendaEntities = iAgendaRepository.findAll();
        model.addAttribute("agenda",agendaEntities);
        return "agendaListado";
    }
}
