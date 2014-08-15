package reservation.entites;

import reservation.objects.Reservation;

public class NeudReservations {
	public Reservation racine;
	private NeudReservations precedents;
	private NeudReservations suivants;

	public Reservation getRacine() {
		return racine;
	}

	public void setRacine(Reservation racine) {
		this.racine = racine;
	}

	public NeudReservations getPrecedents() {
		return precedents;
	}

	public void setPrecedents(NeudReservations precedents) {
		this.precedents = precedents;
	}

	public NeudReservations getSuivants() {
		return suivants;
	}

	public void setSuivants(NeudReservations suivants) {
		this.suivants = suivants;
	}

	public void add(Reservation reservation) {
	}

	public void remove(Reservation reservation) {
		detruit(this, reservation);
	}

	private void detruit(NeudReservations noeud, Reservation reservation) {
		if (noeud != null) {
			if (noeud.getRacine().equals(reservation)) {

				noeud = null;
				// noeud.getPrecedents().
			} else if (noeud.getPrecedents().getRacine().compareTo(reservation) > 0) {
				detruit(noeud.getPrecedents(), reservation);
			} else
				detruit(noeud.getSuivants(), reservation);
		}

	}

	public int size() {
		return 0;
	}

}
