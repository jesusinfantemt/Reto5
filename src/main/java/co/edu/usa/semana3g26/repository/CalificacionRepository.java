/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.repositorios.crud.CalificacionCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANDRES
 */
@Repository
public class CalificacionRepository {

    @Autowired
    private CalificacionCrudRepository calificacionCrudRepository;

    public List<Calificacion> getAll() {
        return (List<Calificacion>) calificacionCrudRepository.findAll();
    }

    public Optional<Calificacion> getCalificacion(int idCalification) {
        return calificacionCrudRepository.findById(idCalification);
    }

    public Calificacion save(Calificacion ca) {
        return calificacionCrudRepository.save(ca);
    }

    public void delete(Calificacion ca) {
        calificacionCrudRepository.delete(ca);
    }
}
