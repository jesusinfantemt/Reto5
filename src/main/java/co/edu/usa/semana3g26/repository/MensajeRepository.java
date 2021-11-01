package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.modelo.Mensaje;
import co.edu.usa.semana3g26.repositorios.crud.MensajeCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANDRES
 */
@Repository
public class MensajeRepository {

    @Autowired
    private MensajeCrudRepository mensajeCrudRepository;

    public List<Mensaje> getAll() {
        return (List<Mensaje>) mensajeCrudRepository.findAll();
    }

    public Optional<Mensaje> getMensaje(int idMessage) {
        return mensajeCrudRepository.findById(idMessage);
    }

    public Mensaje save(Mensaje m) {
        return mensajeCrudRepository.save(m);
    }

    public void delete(Mensaje mensaje) {
        mensajeCrudRepository.delete(mensaje);
    }
}
