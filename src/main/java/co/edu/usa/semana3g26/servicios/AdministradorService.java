/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Administrador;
import co.edu.usa.semana3g26.repository.AdministradorRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class AdministradorService {
    
    @Autowired
    private AdministradorRepository administradorRepository;

    public List<Administrador> getAll() {
        return administradorRepository.getAll();
    }

    public Optional<Administrador> getAdministrador(int idAdministrator) {
        return administradorRepository.getAdministrador(idAdministrator);
    }

    public Administrador save(Administrador a) {
        if (a.getIdAdministrator() == null) {
            return administradorRepository.save(a);
        } else {
            Optional<Administrador> adaux = administradorRepository.getAdministrador(a.getIdAdministrator());
            if (adaux.isEmpty()) {
                return administradorRepository.save(a);
            } else {
                return a;
            }
        }
    }
    
    public Administrador update(Administrador a) {
        if (a.getIdAdministrator()!= null) {
            Optional<Administrador> ad = administradorRepository.getAdministrador(a.getIdAdministrator());
            if (!ad.isEmpty()) {

                if (a.getName()!= null) {
                    ad.get().setName(a.getName());
                }
                if (a.getCorreo()!= null) {
                    ad.get().setCorreo(a.getCorreo());
                }
                if (a.getPassword()!= null) {
                    ad.get().setPassword(a.getPassword());
                }
                administradorRepository.save(ad.get());
                return ad.get();
            } else {
                return a;
            }
        } else {
            return a;
        }
    }

    public boolean deleteAdministrador(int AdministradorId) {
        Boolean aBoolean = getAdministrador(AdministradorId).map(administrator -> {
            administradorRepository.delete(administrator);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
