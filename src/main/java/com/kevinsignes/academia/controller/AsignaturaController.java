package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.AsignaturaEntity;
import com.kevinsignes.academia.basededatos.AulaEntity;
import com.kevinsignes.academia.repository.IAsignaturaRepository;
import com.kevinsignes.academia.repository.IAulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class AsignaturaController {

    @Autowired
    private IAsignaturaRepository iAsignaturaRepository;

    @GetMapping({"/asignatura"})
    public String goTocurso(Model model){
        model.addAttribute("asignatura", new AsignaturaEntity());
        return "asignatura";
    }
    @PostMapping("/asignatura/submit")
    public String processAsignatura(@ModelAttribute("asignatura") AsignaturaEntity asignatura) {
        iAsignaturaRepository.save(asignatura);
        return "redirect:/asignatura/all";
    }
    @GetMapping("/asignatura/all")
    public String processAsignaturaList(Model model) {
        List<AsignaturaEntity> asignaturaEntities = iAsignaturaRepository.findAll();
        model.addAttribute("asignaturas",asignaturaEntities);
        return "asignaturaListado";
    }
}
