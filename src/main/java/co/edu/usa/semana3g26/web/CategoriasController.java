
package co.edu.usa.semana3g26.web;

import co.edu.usa.semana3g26.modelo.Categorias;
import co.edu.usa.semana3g26.servicios.CategoriasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class CategoriasController {

    @Autowired
    private CategoriasService categoriasService;

    @GetMapping("/all")
    public List<Categorias> getCategoriass(){
        return categoriasService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Categorias> getCategorias(@PathVariable("id") int id){
        return categoriasService.getCategorias(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorias save(@RequestBody Categorias c){
        return categoriasService.save(c);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Categorias update(@RequestBody Categorias c) {
        return categoriasService.update(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int categoriaId) {
        return categoriasService.deleteCategoria(categoriaId);
    }
    
}