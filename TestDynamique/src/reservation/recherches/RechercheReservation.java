package reservation.recherches;

import reservation.dto.ReservationDTO;

public abstract class RechercheReservation extends AbstractRecherche {

	protected ReservationDTO[] resultats = null;

	public RechercheReservation() {

	}

	@Override
	public ReservationDTO[] rechercherReservations() {

		effectuerRecherche();
		if (resultats == null)
			resultats = new ReservationDTO[0];
		return resultats;
	}

}
