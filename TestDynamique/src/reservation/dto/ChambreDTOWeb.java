package reservation.dto;

import reservation.objects.Chambre;

public class ChambreDTOWeb extends ChambreDTO {

	public ChambreDTOWeb() {
		super();
	}

	public ChambreDTOWeb(Chambre chambre) {
		super(chambre);
		// reservations = new ReservationDTO[chambre.getNombreReservation()];
	}

	// @Override
	// public void setFormulaire(Formulaire formulaire) {
	// this.formulaire = formulaire;
	// }

	@Override
	public ReservationDTO[] getReservations() {
		// Recherche recherche = RechercheFactory
		// .getRechercheReservation(new Chambre(this.getNumeroChambre()));
		// return recherche.rechercherReservations();
		return null;
	}

	@Override
	public void setReservations(ReservationDTO[] reservations) {

	}

	// @Override
	// public Formulaire getFormulaire() {
	//
	// return formulaire;
	// }
}
