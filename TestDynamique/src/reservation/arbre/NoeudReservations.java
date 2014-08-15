package reservation.arbre;

import reservation.objects.Reservation;

public class NoeudReservations {

	private Reservation teteReservation; // donnée
	private NoeudReservations precedent; // premier fils
	private NoeudReservations suivant; // frère

	public NoeudReservations(Reservation element) {
		this(element, null, null);
	}

	public NoeudReservations(Reservation element, NoeudReservations fils,
			NoeudReservations frere) throws RuntimeException {
		super();
		this.teteReservation = element;
		this.precedent = null;
		this.suivant = null;
	}

	public boolean setElement(Reservation element) {
		boolean ok = NoeudReservations.validerElement(element);

		if (ok)

			this.teteReservation = element;
		return ok;
	}

	private static boolean validerElement(Reservation element2) {
		return (element2 != null);
	}

	public Reservation getTeteReservation() {
		return teteReservation;
	}

	public void setTeteReservation(Reservation teteReservation) {
		this.teteReservation = teteReservation;
	}

	public void setPrecedent(NoeudReservations precedent) {
		this.precedent = precedent;
	}

	public void setSuivant(NoeudReservations suivant) {
		this.suivant = suivant;
	}

	public NoeudReservations getPrecedent() {
		return precedent;
	}

	public NoeudReservations getSuivant() {
		return suivant;
	}

}
