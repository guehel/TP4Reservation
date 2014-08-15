package reservation.recherches;

import reservation.SingleGrandLivre;

public class ReservationsParClient extends RechercheReservation {
	private int client;

	public ReservationsParClient(int idClient) {

		this.client = idClient;
	}

	@Override
	protected void effectuerRecherche() {
		this.resultats = SingleGrandLivre.getInstance().rechercheReservationsClient(
				client);

	}
}
