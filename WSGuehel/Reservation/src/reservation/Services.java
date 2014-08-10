package reservation;
import reservation.dto.*;
/**
 * @author Guehel
 *
 */
public interface Services {
/**Pour obtenir liste des chambres dans l'hotel ainsi que leur details 
 * @return  listes des chambres dans l'hotel
 */
public ChambreDTO[] obtenirListeChambre();
/**Obtenir toutes les reservations faites par un client d'un clients 
 * @param idClient numero du client obtenue a partir de la liste des clients
 * @return  le client et ses details de reservations
 */
public ReservationDTO[] obtenirReservations(int idClient);

/**obtenir la listes
 * @return
 */
public ClientDTO[] obtenirListeClients();
public boolean update(ChambreDTO chambre);
}
