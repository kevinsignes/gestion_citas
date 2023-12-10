package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.ServicioEntity;
import com.kevinsignes.gestion_citas.repository.IServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/guardar")
    public String guardarCita(@ModelAttribute("servicio") ServicioEntity servicio) {
        iServicioRepository.save(servicio);
        return "redirect:/mis_citas";
    }
    @PostMapping("/servicio/submit")
    public String processServicio(@ModelAttribute("servicio") ServicioEntity servicio) {
        iServicioRepository.save(servicio);
        return "redirect:/inicio";
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


    @GetMapping("/inicio")
    public String processServicioList(Model model) {
        List<ServicioEntity> servicioEntities = iServicioRepository.findAll();
        model.addAttribute("servicio",servicioEntities);
        return "inicio";
    }

    @GetMapping("/servicios/buscar")
    public String buscarServicios(@RequestParam(name = "busqueda", required = false) String busqueda, Model model) {
        // Aquí deberías implementar la lógica de búsqueda en tu servicio
        // En este ejemplo, se asume que tienes un servicio llamado servicioService que tiene un método de búsqueda

        // Puedes cambiar "servicioService.buscarServicios(busqueda)" por la lógica de búsqueda real
        model.addAttribute("servicios", iServicioRepository.findByServicioEntity(busqueda));

        // También puedes agregar otros atributos al modelo según sea necesario

        // Devuelve la vista que muestra los resultados de la búsqueda
        return "vista-de-resultados";
    }


}
