
package com.proyecto.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.modelos.Localizacion;
import com.proyecto.repositorios.RepositorioLocalizaciones;

@Service
public class ServicioLocalizaciones {

    @Autowired 
    private RepositorioLocalizaciones repositorioLocalizaciones;

    public Localizacion crearLocalizacion(Localizacion localizacion){
        return repositorioLocalizaciones.save(localizacion);
    }

    public List<Localizacion> obtenerTodas(){
        return (List<Localizacion>) this.repositorioLocalizaciones.findAll();
    }
    
    public Localizacion obtenerLocalizacionPorId(Long id){
        return this.repositorioLocalizaciones.findById(id).orElse(null);
    }

    public Localizacion actualizarLocalizacion(Long id, Localizacion localizacion){
        return this.repositorioLocalizaciones.save(localizacion);
    }

    public void eliminarLocalizacion(Long id){
        this.repositorioLocalizaciones.deleteById(id);
    }

    public List<Localizacion> buscarPorNombre(String nombre) {
        return this.repositorioLocalizaciones.buscarPorNombre(nombre);
    }
}
