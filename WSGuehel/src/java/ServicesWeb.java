package reservation;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;

public class ServicesWeb implements Services {
	
	public  ServicesWeb (){
		super();
	}
	
	@Override
	public ChambreDTO[] obtenirListeChambre() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public ClientDTO[] obtenirListeClients() {
		// Test webservice
		ClientDTO client = new ClientDTO();
		client.setId(1);
		client.setNom("Bouanga");
		client.setPrenom("Guehel");
		ReservationDTO resa = new ReservationDTO();
		resa.setArrivee("25 mai");
		resa.setDepart("23-Juin");
		resa.setCreation("01 jan");
		resa.setIdReservation(1);
		ReservationDTO[] res = {resa};
		client.setReservations(res);
		ClientDTO[] tabClients = {client};
		return tabClients;
	}

	@Override
	public boolean update(ChambreDTO chambre) {
		// Test webservice
		System.out.println("num "+chambre.getNumeroChambre());
		System.out.println("num date "+chambre.getFormulaire().getDateModification());
		System.out.println("depart "+chambre.getReservations()[0].getDepart());
		
		return true;
	}


	@Override
	public ChambreDTO[] obtenirReservations(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

}
