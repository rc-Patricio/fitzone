package com.proyecto.controladores;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.proyecto.modelos.Usuario;
import com.proyecto.servicios.ServiciosUsuarios;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorPerfil {

    @Autowired
    private ServiciosUsuarios serviciosUsuarios;

    @GetMapping("/perfil")
public String mostrarPerfil(HttpSession sesion, Model modelo) {
    String emailUsuario = (String) sesion.getAttribute("emailUsuario");

    if (emailUsuario == null) {
        return "redirect:/login";
    }

    Usuario usuario = this.serviciosUsuarios.obtenerPorEmail(emailUsuario);
    if (usuario == null) {
        return "redirect:/login";
    }

    modelo.addAttribute("usuario", usuario);
    modelo.addAttribute("preferencias", usuario.getPreferencia());

    return "perfil"; 
}



    @PostMapping("/perfil/editar")
    public String editarPerfil(@ModelAttribute Usuario usuario, HttpSession sesion, Model model, @RequestParam("file") MultipartFile imagen) {
        String emailUsuario = (String) sesion.getAttribute("emailUsuario");

        if (emailUsuario == null) {
            return "redirect:/login";
        }

        Usuario usuarioSession = this.serviciosUsuarios.obtenerPorEmail(emailUsuario);

        if (usuarioSession == null) {
            return "redirect:/login";
        }

        if (!imagen.isEmpty()) {
            String rutaAbsoluta = "C:/Usuarios/FotoPerfiles/";

            try {
                byte[] bytesImg = imagen.getBytes();
                Path rutaCompleta = Paths.get(rutaAbsoluta + File.separator + imagen.getOriginalFilename());
                Files.write(rutaCompleta, bytesImg);

                // Establecer el nombre del archivo en el usuario
                usuarioSession.setImagen(imagen.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
                return "error";
            }
        } else {
            System.out.println("El archivo está vacío");
        }

        usuarioSession.setNombre(usuario.getNombre());
        usuarioSession.setApellido(usuario.getApellido());
        usuarioSession.setSobreMi(usuario.getSobreMi());

        try {
            this.serviciosUsuarios.actualizarUsuario(usuarioSession);
        } catch (Exception e) {
            return "error";
        }

        sesion.setAttribute("emailUsuario", usuarioSession.getEmail());

        model.addAttribute("nombreUsuario", usuarioSession.getNombre());
        model.addAttribute("apellidoUsuario", usuarioSession.getApellido());
        model.addAttribute("sobreMiUsuario", usuarioSession.getSobreMi());
        model.addAttribute("imagen", "/FotoPerfiles/" + usuarioSession.getImagen());

        return "perfil";
    }



    @GetMapping("/perfil/preferencias")
    public String mostrarPreferencias(@RequestParam ("preferencia") String preferencia, Model modelo, HttpSession sesion) {
        String emailUsuario = (String) sesion.getAttribute("emailUsuario");

        if (emailUsuario == null) {
            return "redirect:/login";
        }

        Usuario usuario = this.serviciosUsuarios.obtenerPorEmail(emailUsuario);
        if (usuario == null) {
            return "redirect:/login";
        }

        
        modelo.addAttribute("usuario", usuario);
        modelo.addAttribute("preferencia", preferencia); 

        return "preferencia";
    }

}
