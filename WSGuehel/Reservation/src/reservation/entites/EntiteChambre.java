package reservation.entites;

import reservation.dto.ChambreDTODB;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;

public class EntiteChambre extends Entite {
	private Chambre chambre;
	private Formulaire formulaire;

	public Formulaire getFormulaire() {
		return formulaire;
	}

	public void setFormulaire(Formulaire formulaire) {
		this.formulaire = formulaire;
	}

	public EntiteChambre(Chambre chambre) {
		super();
		this.chambre = chambre;
	}

	public EntiteChambre(ChambreDTODB chambreDTODB) throws Exception {
		super();
		this.setFromChambreDTO(chambreDTODB);
	}

	public EntiteChambre() {
		super();

	}

	public Chambre getChambre() {
		return chambre;
	}

	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	public ChambreDTODB getChambreDTO() {
		ChambreDTODB chambreDTODB = new ChambreDTODB();
		formulaire = new Formulaire();
		formulaire.getReservation().setChambreDTO(chambreDTODB);
		chambreDTODB.setNumeroChambre(this.chambre.getNumeroChambre());
		chambreDTODB.setReservations(this.getReservationsArray());

		chambreDTODB.setFormulaire(formulaire);
		return chambreDTODB;
	}

	public void setFromChambreDTO(ChambreDTODB chambreDTODB) {
		formulaire = chambreDTODB.getFormulaire();
		ReservationDTO[] reservationsDTO = chambreDTODB.getReservations();
		super.setReservationsFromDTO(reservationsDTO);
		this.chambre = new Chambre(chambreDTODB.getNumeroChambre());
	}

}
