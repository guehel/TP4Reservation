package reservation.recherches;

import reservation.SingleGrandLivre;
import reservation.dto.ClientDTO;
import reservation.entites.EntiteClient;
import reservation.objects.Client;

public class ToutsClients extends RechercheClients {

	@Override
	protected void effectuerRecherche() {
		this.listeClientDTOs = new ClientDTO[SingleGrandLivre.getInstance()
				.getListeClients().size()];
		int i = 0;
		for (Client client : SingleGrandLivre.getInstance().getListeClients()) {
			this.listeClientDTOs[i] = new EntiteClient(client).getClientDTO();
			i++;
		}

	}

}
