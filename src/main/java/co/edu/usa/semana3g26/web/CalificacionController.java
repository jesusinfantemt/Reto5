/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.usa.semana3g26.web;

import co.edu.usa.semana3g26.modelo.Calificacion;
import co.edu.usa.semana3g26.servicios.CalificacionService;
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
@RequestMapping("/api/Calification")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CalificacionController {

    @Autowired
    private CalificacionService calificacionService;

    @GetMapping("/all")
    public List<Calificacion> getCalificaciones(){
        return calificacionService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Calificacion> getCalificacion(@PathVariable("idCalification") int idCalification){
        return calificacionService.getCalificacion(idCalification);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion save(@RequestBody Calificacion ca){
        return calificacionService.save(ca);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Calificacion update(@RequestBody Calificacion ca) {
        return calificacionService.update(ca);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int calificacionId) {
        return calificacionService.deleteCalificacion(calificacionId);
    }

}