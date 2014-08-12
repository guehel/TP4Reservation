package reservation.recherches;

import reservation.dto.ChambreDTO;

public abstract class RechercheChambres extends AbsctractRecherche {

	protected ChambreDTO[] listeChambreDTOs;

	@Override
	public ChambreDTO[] rechercherChambres() {
		effectuerRecherche();
		return listeChambreDTOs;
	}
}
