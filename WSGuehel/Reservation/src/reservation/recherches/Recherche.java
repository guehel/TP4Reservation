/**
 * 
 */
package reservation.recherches;


import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;

/**Interface pour les differente rechers
 * @author Guehel
 *
 */
public interface  Recherche  {
	 ReservationDTO[] rechercherReservations();
	 ClientDTO[] rechercherClients();
	 ChambreDTO[] rechercherChambres();
	
}
