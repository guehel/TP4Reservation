package reservation.recherches;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;
import reservation.entites.Entite;

public abstract class AbsctractRecherche extends Entite implements Recherche {

	public AbsctractRecherche() {

	}

	@Override
	public ReservationDTO[] rechercherReservations() {
		return null;
	}

	@Override
	public ClientDTO[] rechercherClients() {

		return null;
	}

	@Override
	public ChambreDTO[] rechercherChambres() {
		return null;
	}

	protected abstract void effectuerRecherche();
}
