
package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.modelo.Ortesis;
import co.edu.usa.semana3g26.repositorios.crud.OrtesisCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author ANDRES
 */

@Repository
public class OrtesisRepository {
    @Autowired
    private OrtesisCrudRepository ortesisCrudRepository;
    
    public List<Ortesis> getAll(){
        return (List<Ortesis>) ortesisCrudRepository.findAll();
        
    }
    public Optional<Ortesis> getOrtesis(int id){
        return ortesisCrudRepository.findById(id);
    }
    
    public Ortesis save(Ortesis o){
        return ortesisCrudRepository.save(o);
    } 
    
    public void delete(Ortesis ortesis){
        ortesisCrudRepository.delete(ortesis);
    }
}
