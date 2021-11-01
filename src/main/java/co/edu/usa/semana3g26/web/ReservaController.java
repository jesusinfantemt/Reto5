package co.edu.usa.semana3g26.web;

import co.edu.usa.semana3g26.Reportes.ContadorClientes;
import co.edu.usa.semana3g26.Reportes.StatusReservas;
import co.edu.usa.semana3g26.modelo.Reserva;
import co.edu.usa.semana3g26.servicios.ReservaService;
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
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping("/all")
    public List<Reserva> getReservas() {
        return reservaService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reserva> getReserva(@PathVariable("idReservation") int idReservation) {
        return reservaService.getReserva(idReservation);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva save(@RequestBody Reserva r) {
        return reservaService.save(r);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reserva update(@RequestBody Reserva r) {
        return reservaService.update(r);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return reservaService.deleteReserva(reservationId);
    }

   @GetMapping("/report-status")
    public StatusReservas getReserva(){
        return reservaService.getReporteStatusReserva();
    }
    
    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reserva> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return reservaService.getResporteTiempoReserva(dateOne, dateTwo);
    }
        
    @GetMapping("/report-clients")
    public List<ContadorClientes> getClientes(){
        return reservaService.servicioTopClientes();
    
    }
}
