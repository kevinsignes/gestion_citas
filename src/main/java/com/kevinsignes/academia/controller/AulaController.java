package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.AulaEntity;
import com.kevinsignes.academia.basededatos.CursoEntity;
import com.kevinsignes.academia.repository.IAulaRepository;
import com.kevinsignes.academia.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AulaController {

    @Autowired
    private IAulaRepository iAulaRepository;

    @GetMapping({"/aula"})
    public String goToaula(Model model){
        model.addAttribute("aula", new AulaEntity());
        return "aula";
    }
    @PostMapping("/aula/submit")
    public String processAula(@ModelAttribute("aula") AulaEntity aula) {
        iAulaRepository.save(aula);
        return "redirect:/aula/all";
    }
    @GetMapping("/aula/all")
    public String processAulaList(Model model) {
        List<AulaEntity> aulaEntities = iAulaRepository.findAll();
        model.addAttribute("aulas",aulaEntities);
        return "aulaListado";
    }
}
