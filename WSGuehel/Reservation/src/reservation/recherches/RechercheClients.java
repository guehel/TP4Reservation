package reservation.recherches;

import reservation.GrandLivreHotel;
import reservation.dto.ClientDTO;



public abstract class  RechercheClients extends AbsctractRecherche{
	protected ClientDTO[] listeClientDTOs;
	public RechercheClients(GrandLivreHotel grandLivre) {
		super(grandLivre);
		
	}

	@Override
	public ClientDTO[] rechercherClients() {
		effectuerRecherche();
		return listeClientDTOs;
	}
}
