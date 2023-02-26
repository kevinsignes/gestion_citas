package com.kevinsignes.academia.controller;

import com.kevinsignes.academia.basededatos.CursoEntity;
import com.kevinsignes.academia.repository.ICursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class CursoController {
    @Autowired
    private ICursoRepository iCursoRepository;

    @GetMapping({"/curso"})
    public String goTocurso(Model model){
        model.addAttribute("curso", new CursoEntity());
        return "curso";
    }
    @PostMapping("/curso/submit")
    public String processCurso(@ModelAttribute("curso") CursoEntity curso) {
        iCursoRepository.save(curso);
        return "redirect:/curso/all";
    }
    @GetMapping("/curso/all")
    public String processCursoList(Model model) {
        List<CursoEntity> cursoEntities = iCursoRepository.findAll();
        model.addAttribute("cursos",cursoEntities);
        return "cursoListado";
    }
}
