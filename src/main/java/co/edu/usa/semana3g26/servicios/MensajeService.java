package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Mensaje;
import co.edu.usa.semana3g26.repository.MensajeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class MensajeService {

    @Autowired
    private MensajeRepository mensajeRepository;

    public List<Mensaje> getAll() {
        return mensajeRepository.getAll();
    }

    public Optional<Mensaje> getMensaje(int idMessage) {
        return mensajeRepository.getMensaje(idMessage);
    }

    public Mensaje save(Mensaje m) {
        if (m.getIdMessage() == null) {
            return mensajeRepository.save(m);
        } else {
            Optional<Mensaje> menaux = mensajeRepository.getMensaje(m.getIdMessage());
            if (menaux.isEmpty()) {
                return mensajeRepository.save(m);
            } else {
                return m;
            }
        }
    }

    public Mensaje update(Mensaje m) {
        if (m.getIdMessage() != null) {
            Optional<Mensaje> e = mensajeRepository.getMensaje(m.getIdMessage());
            if (!e.isEmpty()) {
                if (m.getMessageText() != null) {
                    e.get().setMessageText(m.getMessageText());
                }
                mensajeRepository.save(e.get());
                return e.get();
            } else {
                return m;
            }
        } else {
            return m;
        }
    }

    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMensaje(messageId).map(message -> {
            mensajeRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
