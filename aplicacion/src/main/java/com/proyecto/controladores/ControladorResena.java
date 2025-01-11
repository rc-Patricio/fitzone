
package com.proyecto.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.modelos.Resena;
import com.proyecto.modelos.Usuario;
import com.proyecto.servicios.ServicioResena;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorResena {

    @Autowired
    private ServicioResena servicioResena;

    @GetMapping("/resenas") // para mostrar todas las resenas de la localizacion en especifico
    public String obtenerResenas(Model modelo, HttpSession sesion){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        List<Resena> resenas = this.servicioResena.obtenerTodasLasResenas();
        modelo.addAttribute("resenas", resenas);
        return "resenas";
    } 

    @GetMapping("/crear")// para crear la resena
    public String mostrarCrearResena(HttpSession sesion){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        return "crearResena";
    }

    @PostMapping("/procesa/crear")// para procesar el crear resena
    public String procesaCrearResena(@ModelAttribute Resena resena, HttpSession sesion){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        Usuario usuarioLogueado = (Usuario) sesion.getAttribute("usuario");

        Long idUsuario = usuarioLogueado.getId();

        this.servicioResena.crearResena(resena, idUsuario);
        return "redirect:/resenas";
    }

    @GetMapping("/resenas/detalle/{id}") //Mostrara el dedtalle de la resena
    public String mostrarResenaPorId(HttpSession sesion, Model modelo, @PathVariable Long id){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        Resena resena = this.servicioResena.obtenerResenaPorId(id);
        modelo.addAttribute("resena", resena);
        return "detalleResena";
    }

    @GetMapping("/resenas/editar/{id}")// Mostrara el formulario para editar una resena
    public String mostrarEditarResena(@PathVariable Long id, Model modelo, HttpSession sesion){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }

        Resena resena = this.servicioResena.obtenerResenaPorId(id);
        modelo.addAttribute("resena", resena);
        return "editarResena";
    }

    @PostMapping("/procesa/editar/{id}")
    public String procesaEditarResena(@PathVariable Long id, @ModelAttribute Resena resena, HttpSession sesion){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }

        this.servicioResena.actualizarResena(id, resena);
        return "redirect:/resenas";
    }

    @GetMapping("/resenas/eliminar/{id}")
    public String eliminarResena(@PathVariable Long id, HttpSession sesion){
        if(sesion.getAttribute("usuario") == null){
            return "redirect:/login";
        }
        Usuario usuarioLogueado = (Usuario) sesion.getAttribute("usuario");

        Resena resena = this.servicioResena.obtenerResenaPorId(id);

        if(resena.getUsuario().getId().equals(usuarioLogueado.getId())){
            this.servicioResena.eliminarResena(id);
            return "redirect:/resenas";
        }else{
            return "detalleResena";
        }
    }

}
