package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import com.kevinsignes.gestion_citas.basededatos.ServicioEntity;
import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import com.kevinsignes.gestion_citas.repository.ICitaRepository;
import com.kevinsignes.gestion_citas.repository.IServicioRepository;
import com.kevinsignes.gestion_citas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private IServicioRepository iServicioRepository;
    @Autowired
    private ICitaRepository iCitaRepository;

    @Autowired
    private IUserRepository iUserRepository;


    @GetMapping({"/admin"})
    public String goToAdmin(Model model){
        return "admin";
    }

/** Paginas de Admin De Citas*/
    @GetMapping("/listaCita")
    public String processCitaList(Model model) {
        List<CitaEntity> citaEntities = iCitaRepository.findAll();
        model.addAttribute("cita",citaEntities);
        return "listaCita";
    }
    @PostMapping("/admin/cita/submit")
    public String processCita(@ModelAttribute("cita") CitaEntity cita) {
        iCitaRepository.save(cita);
        return "redirect:/listaCita";
    }

    @RequestMapping("/admin/cita/editar/{id}")
    public String editarCita(@PathVariable int id, Model modelo){

        modelo.addAttribute("cita",
                iCitaRepository.findById(id).get());
        return "admin_editar_cita";
    }


    @PostMapping ("/admin/cita/actualizar")
    public String actualizaCita(@ModelAttribute("cita") CitaEntity citaEntity){
        iCitaRepository.save(citaEntity);
        return "redirect:/listaCita";
    }

    @GetMapping ("/admin/cita/borrar/{id}")
    public String borrarCita(@PathVariable int id){
        iCitaRepository.deleteById(id);
        return "redirect:/listaCita";
    }

    /** Paginas de Admin De Servicio*/

    @PostMapping("/admin/guardar")
    public String guardarCita(@ModelAttribute("servicio") ServicioEntity servicio) {
        iServicioRepository.save(servicio);
        return "redirect:/listaServicio";
    }

    @PostMapping("/admin/servicio/submit")
    public String processServicio(@ModelAttribute("servicio") ServicioEntity servicio) {
        iServicioRepository.save(servicio);
        return "redirect:/listaServicio";
    }


    @RequestMapping ("/admin/editar/{id}")
    public String editarServicio(@PathVariable int id, Model modelo){

        modelo.addAttribute("servicio",
                iServicioRepository.findById(id).get());
        return "admin_editar_servicio";
    }

    @PostMapping ("/admin/actualizar")
    public String actualizaServicio(@ModelAttribute("servicio") ServicioEntity servicioEntity){
        iServicioRepository.save(servicioEntity);
        return "redirect:/listaServicio";
    }

    @GetMapping ("/admin/borrar/{id}")
    public String borrarServicio(@PathVariable int id){
        iServicioRepository.deleteById(id);
        return "redirect:/listaServicio";
    }


    @GetMapping("/listaServicio")
    public String processServicioList(Model model) {
        List<ServicioEntity> servicioEntities = iServicioRepository.findAll();
        model.addAttribute("servicio",servicioEntities);
        return "listaServicio";
    }

    /**Paginas para el USER*/



    @GetMapping("/listaUser")
    public String processUserList(Model model) {
        List<UserEntity> userEntities = iUserRepository.findAll();
        model.addAttribute("user",userEntities);
        return "listaUser";
    }


    @RequestMapping ("/admin/editar/user/{id}")
    public String editarUser(@PathVariable int id, Model modelo){

        modelo.addAttribute("user",
                iUserRepository.findById(id).get());
        return "admin_editar_user";
    }

    @PostMapping ("/admin/actualizar/user")
    public String actualizaUser(@ModelAttribute("user") UserEntity user){
        iUserRepository.save(user);
        return "redirect:/listaUser";
    }

    @GetMapping ("/admin/borrar/user/{id}")
    public String borrarUser(@PathVariable int id){
        iUserRepository.deleteById(id);
        return "redirect:/listaUser";
    }

}
