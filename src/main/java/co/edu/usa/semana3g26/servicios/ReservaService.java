package co.edu.usa.semana3g26.servicios;

import co.edu.usa.semana3g26.Reportes.ContadorClientes;
import co.edu.usa.semana3g26.Reportes.StatusReservas;
import co.edu.usa.semana3g26.modelo.Reserva;
import co.edu.usa.semana3g26.repository.ReservaRepository;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ANDRES
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAll() {
        return reservaRepository.getAll();
    }

    public Optional<Reserva> getReserva(int idReservation) {
        return reservaRepository.getReserva(idReservation);
    }

    public Reserva save(Reserva r) {
        if (r.getIdReservation() == null) {
            return reservaRepository.save(r);
        } else {
            Optional<Reserva> reaux = reservaRepository.getReserva(r.getIdReservation());
            if (reaux.isEmpty()) {
                return reservaRepository.save(r);
            } else {
                return r;
            }
        }
    }

    public Reserva update(Reserva r) {
        if (r.getIdReservation() != null) {
            Optional<Reserva> e = reservaRepository.getReserva(r.getIdReservation());
            if (!e.isEmpty()) {

                if (r.getStartDate() != null) {
                    e.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    e.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    e.get().setStatus(r.getStatus());
                }
                reservaRepository.save(e.get());
                return e.get();
            } else {
                return r;
            }
        } else {
            return r;
        }
    }

    public boolean deleteReserva(int reservationId) {
        Boolean aBoolean = getReserva(reservationId).map(reservation -> {
            reservaRepository.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    public StatusReservas getReporteStatusReserva(){
        List<Reserva>completed=reservaRepository.ReservaStatus("completed");
        List<Reserva>cancelled=reservaRepository.ReservaStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());     
    }
    
    public List<Reserva> getResporteTiempoReserva(String dateA, String dateB){
        SimpleDateFormat parser=new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();
        try{
            datoUno = parser.parse(dateA);
            datoDos = parser.parse(dateB);
        }catch(ParseException event){
            event.printStackTrace();
        }if(datoUno.before(datoDos)){
            return reservaRepository.ReservaTiempo(datoUno, datoDos);
        
        }else{
            return new ArrayList<>();
        
        }
    }
    public List<ContadorClientes> servicioTopClientes(){
        return reservaRepository.getTopClientes();
    }
}
