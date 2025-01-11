package com.proyecto.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.modelos.LoginUsuario;
import com.proyecto.modelos.Usuario;
import com.proyecto.servicios.ServiciosUsuarios;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ControladorUsuario {

    @Autowired
    private ServiciosUsuarios serviciosUsuarios;

    @GetMapping("/")
    public String formRegistro(Model modelo){
        modelo.addAttribute("usuario", new Usuario());
        return "registro";
    }

    @GetMapping("/login")
    public String formLogin(Model modelo){
        modelo.addAttribute("loginUsuario", new LoginUsuario());
        return "login";
    }
    
    @GetMapping("/logout")
    public String logOut(HttpSession sesion){
        sesion.invalidate();
        return "redirect:/login";
    }

    @PostMapping("/procesa/login") //Para procesar la info de login
    public String login(@Valid @ModelAttribute ("loginUsuario") LoginUsuario loginUsuario, BindingResult validaciones, Model modelo, HttpSession sesion){
        this.serviciosUsuarios.validarLogin(validaciones, loginUsuario);
        if(validaciones.hasErrors()){
            //modelo.addAttribute("loginUsuario", new LoginUsuario());
            return "login";
        }
        Usuario usuario = this.serviciosUsuarios.obtenerPorEmail(loginUsuario.getEmail());
        if (usuario == null) {
            modelo.addAttribute("error", "Usuario no encontrado");
        }

        sesion.setAttribute("emailUsuario", usuario.getEmail());

        sesion.setAttribute("nombreCompleto", usuario.getNombre() + " " + usuario.getApellido());
        sesion.setAttribute("idUsuario", usuario.getId());
        return "redirect:/localizaciones";
    }

    @PostMapping("/register")
    public String registro(@Valid @ModelAttribute("usuario") Usuario usuario, Model modelo, HttpSession sesion, BindingResult validaciones){
        System.out.println(usuario.toString());
        this.serviciosUsuarios.validarRegistro(validaciones, usuario);
        if(validaciones.hasErrors()){
            // modelo.addAttribute("usuario", new Usuario());
            return "registro";
        }

        Usuario usuario2 = this.serviciosUsuarios.crearUsuario(usuario);
        sesion.setAttribute("nombreCompleto", usuario2.getNombre() + " " + usuario2.getApellido());
        sesion.setAttribute("idUsuario", usuario2.getId());
        return "redirect:/localizaciones";
    }

    @DeleteMapping("/perfil/eliminar/")
    // ELIMINAR UN USUARIO
    public String eliminarusuario(HttpSession sesion) {
        String emailUsuario = (String) sesion.getAttribute("emailUsuario");

        if(emailUsuario == null){
            return "redirect:/login";
        }
        this.serviciosUsuarios.eliminarUsuarioPorEmail(emailUsuario);
        sesion.invalidate();
        return "redirect:/registro";
    }
}
