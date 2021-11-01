
package co.edu.usa.semana3g26.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ANDRES
 */
@Entity
@Table(name="message")
public class Mensaje implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;

    @ManyToOne
    @JoinColumn(name = "ortesisId")
    @JsonIgnoreProperties({"messages", "client", "reservations"})
    private Ortesis ortopedic;

    @ManyToOne
    @JoinColumn(name = "clienteId")
    @JsonIgnoreProperties({"messages", "reservations", "client"})
    private Cliente client;
    
    /*@ManyToOne
    @JoinColumn(name = "reservaId")
    @JsonIgnoreProperties("messages")
    private Reserva reservation;*/

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Ortesis getOrtopedic() {
        return ortopedic;
    }

    public void setOrtopedic(Ortesis ortopedic) {
        this.ortopedic = ortopedic;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }

    /*public Reserva getReservation() {
        return reservation;
    }

    public void setReservation(Reserva reservation) {
        this.reservation = reservation;
    }*/
}
