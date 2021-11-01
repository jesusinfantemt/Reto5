/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.repositorios.crud.ClienteCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANDRES
 */
@Repository
public class ClienteRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    public List<Cliente> getAll() {
        return (List<Cliente>) clienteCrudRepository.findAll();
    }

    public Optional<Cliente> getCliente(int idClient) {
        return clienteCrudRepository.findById(idClient);
    }

    public Cliente save(Cliente cl) {
        return clienteCrudRepository.save(cl);
    }

    public void delete(Cliente cliente) {
        clienteCrudRepository.delete(cliente);
    }
}
