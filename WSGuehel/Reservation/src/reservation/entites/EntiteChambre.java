package reservation.entites;

import reservation.dto.ChambreDTO;
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

	public EntiteChambre(ChambreDTO chambreDTO) throws Exception {
		super();
		this.setFromChambreDTO(chambreDTO);
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

	public ChambreDTO getChambreDTO() {
		ChambreDTO chambreDTO = new ChambreDTO();
		formulaire = new Formulaire();
		formulaire.getReservation().setChambreDTO(chambreDTO);
		chambreDTO.setNumeroChambre(this.chambre.getNumeroChambre());
		chambreDTO.setReservations(this.getReservationsArray());

		chambreDTO.setFormulaire(formulaire);
		return chambreDTO;
	}

	public void setFromChambreDTO(ChambreDTO chambreDTO) {
		formulaire = chambreDTO.getFormulaire();
		ReservationDTO[] reservationsDTO = chambreDTO.getReservations();
		super.setReservationsFromDTO(reservationsDTO);
		this.chambre = new Chambre(chambreDTO.getNumeroChambre());
	}

}
