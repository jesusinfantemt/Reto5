package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.repository.ClienteRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.getAll();
    }

    public Optional<Cliente> getCliente(int getIdClient) {
        return clienteRepository.getCliente(getIdClient);
    }

    public Cliente save(Cliente cl) {
        if (cl.getIdClient() == null) {
            return clienteRepository.save(cl);
        } else {
            Optional<Cliente> cliaux = clienteRepository.getCliente(cl.getIdClient());
            if (cliaux.isEmpty()) {
                return clienteRepository.save(cl);
            } else {
                return cl;
            }
        }
    }

    public Cliente update(Cliente cl) {
        if (cl.getIdClient() != null) {
            Optional<Cliente> e = clienteRepository.getCliente(cl.getIdClient());
            if (!e.isEmpty()) {
                if (cl.getName() != null) {
                    e.get().setName(cl.getName());
                }
                if (cl.getAge() != null) {
                    e.get().setAge(cl.getAge());
                }
                if (cl.getPassword() != null) {
                    e.get().setPassword(cl.getPassword());
                }
                clienteRepository.save(e.get());
                return e.get();
            } else {
                return cl;
            }
        } else {
            return cl;
        }
    }

    public boolean deleteClient(int clientId) {
        Boolean aBoolean = getCliente(clientId).map(client -> {
            clienteRepository.delete(client);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
