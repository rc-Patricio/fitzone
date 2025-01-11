
package com.proyecto.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.modelos.Resena;

@Repository
public interface RepositorioResena extends CrudRepository<Resena, Long>{

}
