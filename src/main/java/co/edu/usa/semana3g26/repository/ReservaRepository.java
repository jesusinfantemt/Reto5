package co.edu.usa.semana3g26.repository;

import co.edu.usa.semana3g26.Reportes.ContadorClientes;
import co.edu.usa.semana3g26.modelo.Cliente;
import co.edu.usa.semana3g26.modelo.Reserva;
import co.edu.usa.semana3g26.repositorios.crud.ReservaCrudRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ANDRES
 */
@Repository
public class ReservaRepository {

    @Autowired
    private ReservaCrudRepository reservaCrudRepository;

    public List<Reserva> getAll() {
        return (List<Reserva>) reservaCrudRepository.findAll();

    }

    public Optional<Reserva> getReserva(int idReservation) {
        return reservaCrudRepository.findById(idReservation);
    }

    public Reserva save(Reserva r) {
        return reservaCrudRepository.save(r);
    }

    public void delete(Reserva r) {
        reservaCrudRepository.delete(r);
    }

    public List<Reserva> ReservaStatus(String status) {
        return reservaCrudRepository.findAllByStatus(status);
    }

    public List<Reserva> ReservaTiempo(Date a, Date b) {
        return reservaCrudRepository.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClientes> getTopClientes() {
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]>report = reservaCrudRepository.countTotalReservationsByClient();
        for (int i = 0; i < report.size(); i++) {
            res.add(new ContadorClientes((Long)report.get(i)[1], (Cliente) report.get(i)[0]));

        }
        return res;
    }

}
