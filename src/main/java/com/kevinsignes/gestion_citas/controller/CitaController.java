package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import com.kevinsignes.gestion_citas.repository.ICitaRepository;
import com.kevinsignes.gestion_citas.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CitaController {

    @Autowired
    private ICitaRepository iCitaRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @GetMapping({"/cita"})
    public String goTocita(Model model){
        model.addAttribute("cita", new CitaEntity());
        return "cita";
    }
    @PostMapping("/cita/submit")
    public String processCita(@ModelAttribute("cita") CitaEntity cita) {
        iCitaRepository.save(cita);
        return "redirect:/citas_usuario";
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
        return "redirect:/citas_usuario";
    }

    @GetMapping ("/cita/borrar/{id}")
    public String borrarCita(@PathVariable int id){
        iCitaRepository.deleteById(id);
        return "redirect:/citas_usuario";
    }

    @GetMapping("/citas_usuario")
    public String mostrarCitasUsuarioActual(Model model) {
        // Obtener la información de autenticación del usuario actual
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String nombreUsuario = authentication.getName();

        // Buscar al usuario actual por su nombre de usuario
        UserEntity usuarioActual = iUserRepository.findByUsuario(nombreUsuario);

        if (usuarioActual != null) {
            // Obtener todas las citas del usuario actual
            List<CitaEntity> citasUsuarioActual = iCitaRepository.findAllByUserId(usuarioActual.getIdUser());

            // Agregar la lista de citas al modelo
            model.addAttribute("citas", citasUsuarioActual);

            // Retornar la vista
            return "citas_usuario";
        } else {
            // Manejar el caso en el que el usuario no se encuentra
            return "redirect:/error";
        }
    }

}
