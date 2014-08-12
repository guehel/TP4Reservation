package reservation.recherches;

import reservation.dto.ClientDTO;

public abstract class RechercheClients extends AbsctractRecherche {
	protected ClientDTO[] listeClientDTOs;

	@Override
	public ClientDTO[] rechercherClients() {
		effectuerRecherche();
		return listeClientDTOs;
	}
}
