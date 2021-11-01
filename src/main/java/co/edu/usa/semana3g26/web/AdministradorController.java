/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.web;

import co.edu.usa.semana3g26.modelo.Administrador;
import co.edu.usa.semana3g26.servicios.AdministradorService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ANDRES
 */
@RestController
@RequestMapping("/api/Administrator")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    @GetMapping("/all")
    public List<Administrador> getAdministradores(){
        return administradorService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Administrador> getAdministrador(@PathVariable("idAdministrator") int idAdministrator){
        return administradorService.getAdministrador(idAdministrator);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador save(@RequestBody Administrador a){
        return administradorService.save(a);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Administrador update(@RequestBody Administrador a) {
        return administradorService.update(a);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int administratorId) {
        return administradorService.deleteAdministrador(administratorId);
    }

}
