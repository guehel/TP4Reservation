package reservation.entites;

import reservation.dto.ChambreDTO;
import reservation.dto.ChambreDTOWeb;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;

public class EntiteChambre /* extends Entite */{
	private Chambre chambre;

	public void setFormulaire(Formulaire formulaire) {

	}

	public EntiteChambre(Chambre chambre) {
		super();
		this.chambre = chambre;
	}

	public EntiteChambre(ChambreDTO chambreDTODB) throws Exception {
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

	public ChambreDTO getChambreDTO() {
		ChambreDTO ChambreDTOWeb = new ChambreDTOWeb();
		// formulaire = new Formulaire();
		// formulaire.getReservation().setChambreDTO(ChambreDTOWeb);
		ChambreDTOWeb.setNumeroChambre(this.chambre.getNumeroChambre());
		// ChambreDTOWeb.setReservations(this.getReservationsArray());

		// ChambreDTOWeb.setFormulaire(formulaire);
		return ChambreDTOWeb;
	}

	public void setFromChambreDTO(ChambreDTO chambreDTODB) {
		// formulaire = chambreDTODB.getFormulaire();
		ReservationDTO[] reservationsDTO = chambreDTODB.getReservations();
		// super.setReservationsFromDTO(reservationsDTO);
		this.chambre = new Chambre(chambreDTODB.getNumeroChambre());
	}

}
