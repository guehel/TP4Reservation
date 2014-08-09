package reservation.recherches;

import java.util.TreeSet;

import reservation.objects.ComparateurReservation;
import reservation.objects.Entite;
import reservation.objects.Reservation;

public abstract class RechercheReservation extends Entite implements Recherche<Reservation> {
	 protected TreeSet<Reservation> resultats = new TreeSet<Reservation>(
			new ComparateurReservation());

	public RechercheReservation(TreeSet<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public RechercheReservation() {
	
	}

	public TreeSet<Reservation> getResultats() {
		return resultats;
	}


}
