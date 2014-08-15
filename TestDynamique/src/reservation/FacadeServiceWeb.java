package reservation;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

public class FacadeServiceWeb implements Services {

	private ServicesWeb service;

	public FacadeServiceWeb() {
		System.out.println("demarage de service");
		service = new ServicesWeb();
	}

	@Override
	public ChambreDTO[] obtenirListeChambre() {
		System.out.println("Demande de liste des chambres");
		if (service == null)
			return null;
		else {

			ChambreDTO[] tab = service.obtenirListeChambre();
			for (ChambreDTO chambreSelectionne : tab) {
				ApplicationLineDeCommande.afficherChambre(chambreSelectionne);
			}
			return tab;
		}
	}

	@Override
	public ReservationDTO[] obtenirReservations(int idClient) {
		System.out.println("obtenirReservations" + idClient);
		if (service == null)
			return null;
		else {
			ReservationDTO[] tab = service.obtenirReservations(idClient);
			for (ReservationDTO resDTO : tab) {
				ApplicationLineDeCommande.afficherReservation(resDTO);
			}
			return service.obtenirReservations(idClient);
		}
	}

	@Override
	public ClientDTO[] obtenirListeClients() {
		System.out.println("obtenir**ListeClients");
		if (service == null)
			return null;
		else {
			ClientDTO[] tab = service.obtenirListeClients();
			for (ClientDTO client : tab)
				ApplicationLineDeCommande.afficherClient(client);
			return tab;
		}
	}

	@Override
	public boolean update(Formulaire chambreDTO) {
		System.out.println("mettre a jour reservation\formulaire demandee");
		ApplicationLineDeCommande.afficherFormulaire(chambreDTO);
		if (service == null)
			return false;
		else {
			boolean ok = false;
			ok = service.update(chambreDTO);

			System.out.println(ok ? "maj OK" : "maj echac");
			return ok;
		}
	}

}
