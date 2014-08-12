package reservation.recherches;

import reservation.SingleGrandLivre;
import reservation.objects.Reservation;

public class ReservationDeReservation extends RechercheReservation {

	private Reservation pReservation;

	public ReservationDeReservation(Reservation reservation) {

		this.pReservation = reservation;
	}

	@Override
	protected void effectuerRecherche() {

		for (Reservation reservation : SingleGrandLivre.getInstance()
				.getReservations()) {
			if (reservation.equals(this.pReservation)) {
				this.reservations.add(reservation);
			}
		}
	}

}
