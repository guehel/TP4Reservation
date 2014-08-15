package reservation.recherches;

import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;

public class ReservationsParChambreTest extends RechercheReservation {

	private int chambre;

	public ReservationsParChambreTest(int client) {

		this.chambre = 0;
	}

	public void setChambre(int chambre) {
		this.chambre = chambre;
	}

	@Override
	protected void effectuerRecherche() {
		this.resultats = new ReservationDTO[1];
		ReservationDTO rs = new ReservationDTO();
		rs.setArrivee("2999-01-01");
		rs.setDepart("2999-01-01");
		rs.setCreation("2999-01-01");
		rs.setClientDTO(new ClientDTO());
		this.resultats[0] = rs;
		// this.resultats =
		// SingleGrandLivre.getInstance().rechercheParNumchambre(
		// this.chambre);
		// System.out.println("nombre de resa trouve =" + resultats.length);
	}

}
