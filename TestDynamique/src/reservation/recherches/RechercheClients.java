package reservation.recherches;

import reservation.dto.ClientDTO;

public abstract class RechercheClients extends AbstractRecherche {
	protected ClientDTO[] listeClientDTOs;

	@Override
	public ClientDTO[] rechercherClients() {
		effectuerRecherche();
		return listeClientDTOs;
	}
}
