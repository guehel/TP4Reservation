package reservation.recherches;

import reservation.SingleGrandLivre;
import reservation.objects.Chambre;

public class ReservationsParChambre extends RechercheReservation {

	private Chambre chambre;

	public ReservationsParChambre(Chambre client) {

		this.chambre = client;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@Override
	protected void effectuerRecherche() {

		SingleGrandLivre.getInstance().rechercheReservations(this.chambre);
	}

}
