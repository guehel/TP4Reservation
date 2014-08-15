/**
 * 
 */
package reservation.recherches;


import reservation.dto.ChambreDTOWeb;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;

/**Interface pour les differente rechers
 * @author Guehel
 *
 */
public interface  Recherche  {
	 ReservationDTO[] rechercherReservations();
	 ClientDTO[] rechercherClients();
	 ChambreDTOWeb[] rechercherChambres();
	
}
