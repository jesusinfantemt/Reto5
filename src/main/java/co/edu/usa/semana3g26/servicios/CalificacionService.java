/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.repository.CalificacionRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class CalificacionService {

    @Autowired
    private CalificacionRepository calificacionRepository;

    public List<Calificacion> getAll() {
        return calificacionRepository.getAll();
    }

    public Optional<Calificacion> getCalificacion(int idCalification) {
        return calificacionRepository.getCalificacion(idCalification);
    }

    public Calificacion save(Calificacion ca) {
        if (ca.getIdCalification() == null) {
            return calificacionRepository.save(ca);
        } else {
            Optional<Calificacion> calaux = calificacionRepository.getCalificacion(ca.getIdCalification());
            if (calaux.isEmpty()) {
                return calificacionRepository.save(ca);
            } else {
                return ca;
            }
        }
    }

    public Calificacion update(Calificacion ca) {
        if (ca.getIdCalification() != null) {
            Optional<Calificacion> e = calificacionRepository.getCalificacion(ca.getIdCalification());
            if (!e.isEmpty()) {

                if (ca.getCalification()!= null) {
                    e.get().setIdCalification(ca.getCalification());
                }
                if (ca.getMessage()!= null) {
                    e.get().setMessage(ca.getMessage());
                }
                if (ca.getReservation()!= null) {
                    e.get().setReservation(ca.getReservation());
                }
                calificacionRepository.save(e.get());
                return e.get();
            } else {
                return ca;
            }
        } else {
            return ca;
        }
    }

    public boolean deleteCalificacion(int calificacionId) {
        Boolean aBoolean = getCalificacion(calificacionId).map(calification -> {
            calificacionRepository.delete(calification);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
