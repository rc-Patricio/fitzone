
package com.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.modelos.Resena;
import com.proyecto.modelos.Usuario;
import com.proyecto.repositorios.RepositorioResena;

@Service
public class ServicioResena {

    @Autowired 
    private RepositorioResena repositorioResena;

    @Autowired
    private ServiciosUsuarios serviciosUsuarios;

    public Resena crearResena(Resena resena, Long idUsuario){
        Usuario usuario = this.serviciosUsuarios.obtenerPorId(idUsuario);
        resena.setUsuario(usuario);
        return repositorioResena.save(resena);
    }

    public List<Resena> obtenerTodasLasResenas(){
        return (List<Resena>) this.repositorioResena.findAll();
    }
    
    public Resena obtenerResenaPorId(Long id){
        return this.repositorioResena.findById(id).orElse(null);
    }

    public Resena actualizarResena(Long id, Resena actualizada){
        Resena resena = this.obtenerResenaPorId(id);
        resena.setPuntuacion(actualizada.getPuntuacion());
        resena.setComentario(actualizada.getComentario());
        return this.repositorioResena.save(resena);
    }

    public void eliminarResena(Long id){
        this.repositorioResena.deleteById(id);
    }
}
