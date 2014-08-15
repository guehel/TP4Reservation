package reservation.recherches;

import reservation.dto.ChambreDTODB;
import reservation.dto.ChambreDTOWeb;

public abstract class RechercheChambres extends AbstractRecherche {

	protected ChambreDTOWeb[] listeChambreDTOs;

	@Override
	public ChambreDTOWeb[] rechercherChambres() {
		effectuerRecherche();
		return listeChambreDTOs;
	}
}
