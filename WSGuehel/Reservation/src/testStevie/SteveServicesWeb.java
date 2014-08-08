package testStevie;

import reservation.Services;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

public class SteveServicesWeb implements Services
{

	@Override
	public ChambreDTO[] obtenirListeChambre() 
	{
		ChambreDTO[] chambreList = new ChambreDTO[2];
		
		ChambreDTO chambre1 = new ChambreDTO();
		chambre1.setNumeroChambre(1);
		Formulaire form1 = new Formulaire();
		chambre1.setFormulaire(form1);
		chambreList[0] = chambre1;
		
		ChambreDTO chambre2 = new ChambreDTO();
		chambre2.setNumeroChambre(2);
		Formulaire form2 = new Formulaire();
		chambre2.setFormulaire(form2);
		chambreList[1] = chambre2;
		
		return null;
	}

	@Override
	public ReservationDTO[] obtenirReservations(int idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientDTO[] obtenirListeClients() {
		
		ClientDTO[] clientList = new ClientDTO[1];
		
		ClientDTO client1 = new ClientDTO();
		client1.setId(1);
		client1.setNom("Papouette");
		client1.setPrenom("Steve");
		
		clientList[0] = client1;
		
		return clientList;
	}

	@Override
	public boolean update(ChambreDTO chambre) {

		System.out.println("Chambre reçue");
		return false;
	}
}
