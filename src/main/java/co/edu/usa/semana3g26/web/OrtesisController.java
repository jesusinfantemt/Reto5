
package co.edu.usa.semana3g26.web;


import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.servicios.OrtesisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Ortopedic")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class OrtesisController {

    @Autowired
    private OrtesisService ortesisService;

    @GetMapping("/all")
    public List<Ortesis> getOrtesiss(){
        return ortesisService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Ortesis> getOrtesis(@PathVariable("id") int id){
        return ortesisService.getOrtesis(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortesis save(@RequestBody Ortesis o){
        return ortesisService.save(o);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Ortesis update(@RequestBody Ortesis o) {
        return ortesisService.update(o);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int ortesisId) {
        return ortesisService.deleteOrtesis(ortesisId);
    }

}