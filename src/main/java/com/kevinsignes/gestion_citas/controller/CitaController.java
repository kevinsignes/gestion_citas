package com.kevinsignes.gestion_citas.controller;

import com.kevinsignes.gestion_citas.basededatos.CitaEntity;
import com.kevinsignes.gestion_citas.basededatos.UserEntity;
import com.kevinsignes.gestion_citas.repository.ICitaRepository;
import com.kevinsignes.gestion_citas.repository.IServicioRepository;
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

    @Autowired
    private IServicioRepository iServicioRepository;

    // Método para mostrar el formulario de cita
    @GetMapping("/cita")
    public String mostrarFormularioCita(@RequestParam("servicioId") int servicioId, Model model) {
        // Obtener el nombre del servicio por su ID
        String nombreServicio = iServicioRepository.findNombreById(servicioId);

        // Agregar el nombre del servicio al modelo
        model.addAttribute("nombreServicio", nombreServicio);

        // Obtener la imagen del servicio por su ID
        String imagenServicio = iServicioRepository.findImagenById(servicioId);

        // Agregar el imagen del servicio al modelo
        model.addAttribute("imagenServicio", imagenServicio);

        // Obtener el categoria del servicio por su ID
        String categoriaServicio = iServicioRepository.findCategoriaById(servicioId);

        // Agregar el categoria del servicio al modelo
        model.addAttribute("categoriaServicio", categoriaServicio);

        // Obtener el descripcion del servicio por su ID
        double precioServicio = iServicioRepository.findPrecioById(servicioId);

        // Agregar el descripcion del servicio al modelo
        model.addAttribute("precioServicio", precioServicio);

        // Agregar un objeto CitaEntity vacío al modelo
        model.addAttribute("cita", new CitaEntity());

        // Retornar el nombre de la página HTML del formulario de cita
        return "cita";
    }

    // Método para procesar el formulario de cita
    @PostMapping("/cita/submit")
    public String submitCita(@ModelAttribute("cita") CitaEntity cita, Model model) {
        // Guardar la cita en la base de datos
        iCitaRepository.save(cita);

        return "redirect:/buscar"; // Redirigir a la página de búsqueda
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
