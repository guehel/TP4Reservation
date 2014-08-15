package reservation.entites;

import reservation.arbre.ArbreBinaireReservations;
import reservation.dto.ReservationDTO;
import reservation.entites.EntiteReservation;
import reservation.objects.Reservation;

/**
 * Classe absctraite pour factorise le code de traitement des set de reservation
 * 
 * @author boug18087415
 *
 */
public class Entite {
	protected ArbreBinaireReservations reservations;

	public Entite() {
		reservations = new ArbreBinaireReservations();

	}

	public ArbreBinaireReservations getReservations() {
		return reservations;
	}

	public void setReservations(ArbreBinaireReservations reservations) {
		this.reservations = reservations;
	}

	public void ajouterReservation(Reservation reservation) {
		reservations.add(reservation);
	}

	public void ajouterReservation(ReservationDTO reservationDTO)
			throws Exception {

		Reservation reservation = new EntiteReservation(reservationDTO)
				.getReservation();
		reservations.add(reservation);

	}

	public void supprimerReservation(Reservation reservation) {
		reservations.remove(reservation);
	}

	public void supprimerReservation(ReservationDTO reservationDTO)
			throws Exception {
		Reservation reservation = new EntiteReservation(reservationDTO)
				.getReservation();
		reservations.remove(reservation);
	}

	public ReservationDTO[] getReservationsArray() {
		int n = reservations.size();
		ReservationDTO dto = null;
		ReservationDTO[] array = new ReservationDTO[n];

		int i = 0;
		for (Reservation res : reservations.toArray()) {

			dto = new EntiteReservation(res).getReservationDTO();

			array[i] = dto;
			i++;
		}
		return array;
	}

	public void setReservationsFromDTO(ReservationDTO[] reservationsDTO) {
		EntiteReservation entiteReservation = null;
		for (ReservationDTO reservationDTO : reservationsDTO) {
			try {
				entiteReservation = new EntiteReservation(reservationDTO);
				reservations.add(entiteReservation.getReservation());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public Reservation getReservation(Reservation parametreRecheche) {
		Reservation foundReservation = reservations
				.rechercher(parametreRecheche);
		// if (parametreRecheche != null) {
		// foundReservation = null;
		// Iterator<Reservation> iterator = reservations.iterator();
		// while (iterator.hasNext() && parametreRecheche == null) {
		// foundReservation = iterator.next();
		// if (foundReservation.equals(parametreRecheche))
		// parametreRecheche = foundReservation;
		// else
		// parametreRecheche = null;
		// }
		// }
		if (foundReservation.equals(parametreRecheche))
			return foundReservation;
		else
			return null;

	}

	public boolean contains(Reservation reservation) {

		return this.reservations.contains(reservation);
	}

	public Reservation getReservation(ReservationDTO reservationDTO)
			throws Exception {
		EntiteReservation entiteReservation = new EntiteReservation(
				reservationDTO);

		return getReservation(entiteReservation.getReservation());
	}

	protected boolean valider(Reservation reservation) {

		return reservation != null && reservation.isValide();
	}

}
