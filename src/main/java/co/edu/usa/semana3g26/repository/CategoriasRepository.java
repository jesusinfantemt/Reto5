package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.modelo.Categorias;
import co.edu.usa.semana3g26.repositorios.crud.CategoriasCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANDRES
 */
@Repository
public class CategoriasRepository {

    @Autowired
    private CategoriasCrudRepository categoriasCrudRepository;

    public List<Categorias> getAll() {
        return (List<Categorias>) categoriasCrudRepository.findAll();
    }

    public Optional<Categorias> getCategorias(int id) {
        return categoriasCrudRepository.findById(id);
    }

    public Categorias save(Categorias c) {
        return categoriasCrudRepository.save(c);
    }

    public void delete(Categorias c) {
        categoriasCrudRepository.delete(c);
    }
}
