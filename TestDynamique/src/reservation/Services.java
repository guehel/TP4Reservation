package reservation;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

/**
 * @author Guehel
 *
 */
public interface Services {
	/**
	 * Pour obtenir liste des chambres dans l'hotel ainsi que leur details
	 * 
	 * @return listes des chambres dans l'hotel
	 */
	public ChambreDTO[] obtenirListeChambre();

	/**
	 * Obtenir toutes les reservations faites par un client d'un clients
	 * 
	 * @param idClient
	 *            numero du client obtenue a partir de la liste des clients
	 * @return le client et ses details de reservations
	 */
	public ReservationDTO[] obtenirReservations(int idClient);

	/**
	 * obtenir la listes des client ainsi que leur details est allee si on veux
	 * modifier une reservation
	 * 
	 * @return la liste des clients et leurs details de reservation
	 */
	public ClientDTO[] obtenirListeClients();

	/**
	 * Permet de modifier la reservation de la chambre a travers le formulaire
	 * de modification compris dans la chambre dto
	 * 
	 * @param chambreDTODB
	 *            informations sur la chambre et les details sur les
	 *            reservations
	 * @return
	 */
	public boolean update(Formulaire chambreDTO);
}
