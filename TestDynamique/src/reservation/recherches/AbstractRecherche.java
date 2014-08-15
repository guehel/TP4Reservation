package reservation.recherches;

import reservation.dto.ChambreDTOWeb;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;
import reservation.entites.Entite;

public abstract class AbstractRecherche extends Entite implements Recherche {

	public AbstractRecherche() {

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
	public ChambreDTOWeb[] rechercherChambres() {
		return null;
	}

	protected abstract void effectuerRecherche();
}
