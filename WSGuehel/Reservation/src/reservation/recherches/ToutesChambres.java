package reservation.recherches;

import reservation.SingleGrandLivre;

public class ToutesChambres extends RechercheChambres {

	@Override
	protected void effectuerRecherche() {

		this.listeChambreDTOs = SingleGrandLivre.getInstance()
				.rechercherChambres();

	}

}
