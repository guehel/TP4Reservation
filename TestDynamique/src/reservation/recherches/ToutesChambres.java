package reservation.recherches;

import reservation.GrandLivre;
import reservation.GrandLivreHotel;
import reservation.SingleGrandLivre;

public class ToutesChambres extends RechercheChambres {

	@Override
	protected void effectuerRecherche() {
GrandLivreHotel grandlibre = SingleGrandLivre.getInstance();
 
		this.listeChambreDTOs = grandlibre.rechercherChambres();

	}

}
