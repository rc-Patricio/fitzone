
package com.fitzone.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fitzone.modelos.Resena;

@Repository
public interface RepositorioResena extends CrudRepository<Resena, Long>{

}
