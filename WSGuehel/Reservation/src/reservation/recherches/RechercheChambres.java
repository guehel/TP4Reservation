package reservation.recherches;

import reservation.dto.ChambreDTO;

public abstract class RechercheChambres extends AbstractRecherche {

	protected ChambreDTO[] listeChambreDTOs;

	@Override
	public ChambreDTO[] rechercherChambres() {
		effectuerRecherche();
		return listeChambreDTOs;
	}
}
