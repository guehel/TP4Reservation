package reservation.entites;

import java.util.TreeSet;

import reservation.dto.ReservationDTO;
import reservation.objects.ComparateurReservation;
import reservation.objects.Reservation;

/**
 * Classe absctraite pour factorise le code de traitement des set de reservation
 * 
 * @author boug18087415
 *
 */
public class Entite {
	protected TreeSet<Reservation> reservations;
	protected static final ComparateurReservation COMPARATEUR = new ComparateurReservation();

	public Entite() {
		reservations = new TreeSet<Reservation>(COMPARATEUR);
	}

	public TreeSet<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(TreeSet<Reservation> reservations) {
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
		for (Reservation res : reservations) {

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
		Reservation foundReservation = reservations.floor(parametreRecheche);
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

	public Reservation getReservation(ReservationDTO reservationDTO)
			throws Exception {
		EntiteReservation entiteReservation = new EntiteReservation();

		return getReservation(entiteReservation.getReservation());
	}

}
