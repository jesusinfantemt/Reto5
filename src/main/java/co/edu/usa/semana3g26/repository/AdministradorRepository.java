/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.modelo.Administrador;
import co.edu.usa.semana3g26.repositorios.crud.AdministradorCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANDRES
 */
@Repository
public class AdministradorRepository {

    @Autowired
    private AdministradorCrudRepository administradorCrudRepository;

    public List<Administrador> getAll() {
        return (List<Administrador>) administradorCrudRepository.findAll();
    }

    public Optional<Administrador> getAdministrador(int idAdministrator) {
        return administradorCrudRepository.findById(idAdministrator);
    }

    public Administrador save(Administrador ad) {
        return administradorCrudRepository.save(ad);
    }

    public void delete(Administrador ad) {
        administradorCrudRepository.delete(ad);
    }
}
