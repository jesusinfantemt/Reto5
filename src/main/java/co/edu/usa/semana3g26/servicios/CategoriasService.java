package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.modelo.Categorias;
import co.edu.usa.semana3g26.repository.CategoriasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class CategoriasService {

    @Autowired
    private CategoriasRepository categoriasRepository;

    public List<Categorias> getAll() {
        return categoriasRepository.getAll();
    }

    public Optional<Categorias> getCategorias(int id) {
        return categoriasRepository.getCategorias(id);
    }

    public Categorias save(Categorias c) {
        if (c.getId() == null) {
            return categoriasRepository.save(c);
        } else {
            Optional<Categorias> cateaux = categoriasRepository.getCategorias(c.getId());
            if (cateaux.isEmpty()) {
                return categoriasRepository.save(c);
            } else {
                return c;
            }
        }
    }

    public Categorias update(Categorias c) {
        if (c.getId() != null) {
            Optional<Categorias> g = categoriasRepository.getCategorias(c.getId());
            if (!g.isEmpty()) {
                if (c.getDescription() != null) {
                    g.get().setDescription(c.getDescription());
                }
                if (c.getName() != null) {
                    g.get().setName(c.getName());
                }
                return categoriasRepository.save(g.get());
            }
        }
        return c;
    }

    public boolean deleteCategoria(int categoriaId) {
        Boolean d = getCategorias(categoriaId).map(categoria -> {
            categoriasRepository.delete(categoria);
            return true;
        }).orElse(false);
        return d;
    }
}
