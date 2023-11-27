package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.EmpleadoEntity;
import com.kevinsignes.gestion_citas.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Controller
public class EmpleadoController {

    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @GetMapping({"/empleado"})
    public String goToempleado(Model model){
        model.addAttribute("empleado", new EmpleadoEntity());
        return "empleado";
    }
    @PostMapping("/empleado/submit")
    public String processEmpleado(@ModelAttribute("empleado") EmpleadoEntity empleado) {
        iEmpleadoRepository.save(empleado);
        return "redirect:/inicio";
    }
    @GetMapping("/empleado/all")
    public String processEmpleadoList(Model model) {
        List<EmpleadoEntity> empleadoEntities = iEmpleadoRepository.findAll();
        model.addAttribute("empleado",empleadoEntities);
        return "empleadoListado";
    }
}
