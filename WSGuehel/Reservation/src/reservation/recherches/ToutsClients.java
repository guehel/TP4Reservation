package reservation.recherches;

import reservation.GrandLivreHotel;
import reservation.dto.ClientDTO;
import reservation.entites.EntiteClient;
import reservation.objects.Client;

public class ToutsClients extends RechercheClients {

	public ToutsClients(GrandLivreHotel grandLivre) {
		super(grandLivre);
		
	}

	@Override
	protected void effectuerRecherche() {
		this.listeClientDTOs = new ClientDTO[grandLivre.getListeClients().size()];
		int i=0;
		for(Client client : grandLivre.getListeClients()){
			this.listeClientDTOs[i] = new EntiteClient(client).getClientDTO();
			i++;
		}

	}

}
