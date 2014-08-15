package reservation;

import reservation.dao.OutilsDates;
import reservation.dto.ChambreDTO;
import reservation.dto.ChambreDTODB;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;
import reservation.modifications.Modification;
import reservation.modifications.modificationFactory;
import reservation.recherches.Recherche;
import reservation.recherches.RechercheFactory;

public class ServicesWeb implements Services {
	public static final int NOMBRE_DE_CHAMBRES = 20;

	public ServicesWeb() {
		super();

	}

	@Override
	public ChambreDTO[] obtenirListeChambre() {
		Recherche recherche = RechercheFactory.getRechercheChambres();

		return recherche.rechercherChambres();
	}

	@Override
	public ClientDTO[] obtenirListeClients() {
		Recherche recherche = RechercheFactory.getRechercheClient();

		return recherche.rechercherClients();
	}

	@Override
	public boolean update(Formulaire formulaireModif) {
		boolean reussie = false;

		reussie = validerFormulaireDTO(formulaireModif);
		if (reussie) {
			int type = formulaireModif.getType();
			if (type == 1 || type == 0) {
				ReservationDTO reservationDTO = formulaireModif
						.getReservation();
				Modification modification = modificationFactory
						.getModifications(type);
				reussie = modification.modifier(reservationDTO);
			}
		}
		return reussie;
	}

	@Override
	public ReservationDTO[] obtenirReservations(int idClient) {
		Recherche recherche = RechercheFactory
				.getRechercheReservation(idClient);

		return recherche.rechercherReservations();
	}

	private boolean validerReservationDTO(ReservationDTO reservationDTO) {
		if (reservationDTO == null) {
			return reservationDTO != null;
		}
		String creation = reservationDTO.getCreation();
		String arrivee = reservationDTO.getArrivee();
		String depart = reservationDTO.getDepart();
		boolean valide = (creation != null && OutilsDates.valideDate(creation)
				&& OutilsDates.valideDate(arrivee)
				&& OutilsDates.valideDate(depart)
				&& (creation.compareTo(arrivee) <= 0)
				&& (arrivee.compareTo(depart) < 0)
				&& reservationDTO.getClientDTO().getId() > 0
				&& reservationDTO.getChambreDTO().getNumeroChambre() > 0
				);
	
		if((!valide)){
		ApplicationLineDeCommande.afficherReservation(reservationDTO);
		System.out.println("pas valid");}else{
			System.out.println(" valid");
		}
		return valide;
	}

	// private boolean validerClienDTO(ClientDTO clientDTO) {
	// return clientDTO != null && clientDTO.getId() > 0
	// && clientDTO.getNom() != null && clientDTO.getPrenom() != null;
	// }
	//
	// private boolean validerChambreDTO(ChambreDTO chambreDTO) {
	// return chambreDTO != null && chambreDTO.getNumeroChambre() > 0
	// && chambreDTO.getNumeroChambre() <= NOMBRE_DE_CHAMBRES
	// && validerFormulaireDTO(chambreDTO.getFormulaire());
	// }

	private boolean validerFormulaireDTO(Formulaire formulaire) {

		return formulaire != null
				&& (formulaire.getType() == 0 || formulaire.getType() == 1)
				&& formulaire.getDateModification() != null
				&& validerReservationDTO(formulaire.getReservation());
	}

}
