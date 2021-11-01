package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.repository.OrtesisRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class OrtesisService {

    @Autowired
    private OrtesisRepository ortesisRepository;

    public List<Ortesis> getAll() {
        return ortesisRepository.getAll();
    }

    public Optional<Ortesis> getOrtesis(int id) {
        return ortesisRepository.getOrtesis(id);
    }

    public Ortesis save(Ortesis o) {
        if (o.getId() == null) {
            return ortesisRepository.save(o);
        } else {
            Optional<Ortesis> orteaux = ortesisRepository.getOrtesis(o.getId());
            if (orteaux.isEmpty()) {
                return ortesisRepository.save(o);
            } else {
                return o;
            }
        }
    }

    public Ortesis update(Ortesis o) {
        if (o.getId() != null) {
            Optional<Ortesis> e = ortesisRepository.getOrtesis(o.getId());
            if (!e.isEmpty()) {
                if (o.getName() != null) {
                    e.get().setName(o.getName());
                }
                if (o.getBrand() != null) {
                    e.get().setBrand(o.getBrand());
                }
                if (o.getYear() != null) {
                    e.get().setYear(o.getYear());
                }
                if (o.getDescription() != null) {
                    e.get().setDescription(o.getDescription());
                }
                if (o.getCategory() != null) {
                    e.get().setCategory(o.getCategory());
                }
                ortesisRepository.save(e.get());
                return e.get();
            } else {
                return o;
            }
        } else {
            return o;
        }
    }

    public boolean deleteOrtesis(int ortesisId) {
        Boolean aBoolean = getOrtesis(ortesisId).map(ortesis -> {
            ortesisRepository.delete(ortesis);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
