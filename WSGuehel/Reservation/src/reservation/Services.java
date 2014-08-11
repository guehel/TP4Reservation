package reservation;
import reservation.dto.*;
public interface Services {
public ChambreDTO[] obtenirListeChambre();
public ReservationDTO[] obtenirReservations(int idClient);
public ClientDTO[] obtenirListeClients();
public boolean update(ChambreDTO chambre);
}
