package com.proyecto.servicios;

import java.util.List;
import java.util.NoSuchElementException;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.proyecto.modelos.LoginUsuario;
import com.proyecto.modelos.Usuario;
import com.proyecto.repositorios.RepositorioUsuarios;

@Service
public class ServiciosUsuarios {

    @Autowired
    private RepositorioUsuarios repositorioUsuarios;

    public Usuario crearUsuario(Usuario usuario){
        String hashClave = BCrypt.hashpw(usuario.getClave(), BCrypt.gensalt()); // sirve para encriptar la contrasena
		usuario.setClave(hashClave);
		return this.repositorioUsuarios.save(usuario);
    }

    public List<Usuario> obtenerTodos(){
        return (List<Usuario>) this.repositorioUsuarios.findAll();
    }

    public Usuario obtenerPorId(Long id){
        return this.repositorioUsuarios.findById(id).orElse(null);
    }

    public Usuario obtenerPorEmail(String email){
        return this.repositorioUsuarios.findByEmail(email).orElse(null);
    }

    public Usuario actualizarUsuario(Usuario usuario){
        return this.repositorioUsuarios.save(usuario);
    }

    public void eliminarUsuarioPorId(Long id){
        this.repositorioUsuarios.deleteById(id);
    }

    public void eliminarUsuarioPorEmail(String email){
        this.repositorioUsuarios.findByEmail(email);
    }

    public Usuario actualizarPreferencia(Usuario usuario){
        return this.repositorioUsuarios.save(usuario);
    }

    public String mostrarPreferencia(Long id){
        Usuario usuario = this.repositorioUsuarios.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con id: " + id));
    return usuario.getPreferencia();
    }

    
	public BindingResult validarRegistro(BindingResult validaciones, Usuario usuario) {
		if(!usuario.getClave().equals(usuario.getConfirmarClave())) {
			validaciones.rejectValue("confirmarClave", "clavedNoCoincide", "Las contrasenas no coinciden.");
		}
		return validaciones;
	}
	
	
	public BindingResult validarLogin(BindingResult validaciones, LoginUsuario usuario) {
		Usuario usuarioDb = this.obtenerPorEmail(usuario.getEmail());
		if(usuarioDb == null) {
			validaciones.rejectValue("email", "emailNoRegistrado", "El correo ingresado no se encuentra en nuestra base de datos.");
		}else {
			if(!BCrypt.checkpw(usuario.getClave(), usuarioDb.getClave())) {
				validaciones.rejectValue("clave", "claveIncorrecto", "Contrasena incorrecta.");
			}
		}
		return validaciones;
	}
}
