package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.AgendaEntity;
import com.kevinsignes.academia.basededatos.ClienteEntity;
import com.kevinsignes.academia.repository.IAgendaRepository;
import com.kevinsignes.academia.repository.IClienteRepository;
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
