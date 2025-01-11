package com.proyecto.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.proyecto.modelos.Localizacion;

@Repository
public interface RepositorioLocalizaciones extends CrudRepository<Localizacion, Long>{

    @Query("SELECT l FROM Localizacion l WHERE LOWER(l.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))")
    List<Localizacion> buscarPorNombre(@Param("nombre") String nombre);
}
