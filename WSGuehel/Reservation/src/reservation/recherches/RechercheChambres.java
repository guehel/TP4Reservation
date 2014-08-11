package reservation.recherches;

import reservation.GrandLivreHotel;
import reservation.dto.ChambreDTO;


public abstract class RechercheChambres extends AbsctractRecherche{

	protected ChambreDTO[] listeChambreDTOs;

	public RechercheChambres(GrandLivreHotel grandLivre) {
		super(grandLivre);
			}

	@Override
	public ChambreDTO[] rechercherChambres() {
		effectuerRecherche();
		return listeChambreDTOs;
	}
}
