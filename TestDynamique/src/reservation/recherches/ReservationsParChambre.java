package reservation.recherches;

import reservation.SingleGrandLivre;

public class ReservationsParChambre extends RechercheReservation {

	private int numeroChambre;	

	public ReservationsParChambre(int client) {

		this.numeroChambre = client;
	}

	public void setChambre(int chambre) {
		this.numeroChambre = chambre;
	}

	@Override
	protected void effectuerRecherche() {

		this.resultats = SingleGrandLivre.getInstance().rechercheReservationsParNumchambre(numeroChambre);
	}

}
