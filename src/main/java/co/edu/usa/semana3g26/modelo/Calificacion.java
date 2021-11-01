
package co.edu.usa.semana3g26.modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name="Calification")
public class Calificacion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalification;
    private Integer calification; 
    private String message;
    private Integer reservation;

    public Integer getIdCalification() {
        return idCalification;
    }

    public void setIdCalification(Integer idCalification) {
        this.idCalification = idCalification;
    }

    public Integer getCalification() {
        return calification;
    }

    public void setCalification(Integer calification) {
        this.calification = calification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getReservation() {
        return reservation;
    }

    public void setReservation(Integer reservation) {
        this.reservation = reservation;
    }
    
    
}

