package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.ApplicationLineDeCommande;
import reservation.Services;
import reservation.ServicesWeb;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

public class ServicesWebTest {

	@Test
	public void testServicesWeb() {
		Services services = new ServicesWeb();
		
	}

	@Test
	public void testObtenirListeChambre() {
		
		Services services = new ServicesWeb();
		ChambreDTO[] liste = services.obtenirListeChambre();
		for(ChambreDTO chambreDTO : liste){
			ApplicationLineDeCommande.affichicherChambre(chambreDTO);
		}
	
	}

	@Test
	public void testObtenirListeClients() {
		
	
	}

//	@Test
	public void testUpdate() {
//		ChambreDTO chambreDTO = new ChambreDTO();
//		int numeroChambre=1;
//			Formulaire formulaire = new Formulaire();
//			int type=0;
//			int idUser = 4;
//			String dateModification="2010-05-01";
//			ReservationDTO reservationDTO = new ReservationDTO();
//				int idReservation = 113;	
//				ClientDTO clientDTO = new ClientDTO();	
//					int idClient = 2;
//					String nom = "Martin";
//					String prenom = "Paul";
//					clientDTO.setId(idClient);
//					clientDTO.setNom(nom);
//					clientDTO.setPrenom(prenom);
//				String creation = "2010-05-01";
//				String arrivee = "2015-05-01";
//				String depart = "2016-05-01";
//				ChambreDTO chambreAChange = new ChambreDTO();
//					chambreAChange.setNumeroChambre(numeroChambre);
//				reservationDTO.setIdReservation(idReservation);
//				reservationDTO.setClientDTO(clientDTO);
//				reservationDTO.setCreation(creation);
//				reservationDTO.setArrivee(arrivee);
//				reservationDTO.setDepart(depart);
//				reservationDTO.setChambreDTO(chambreAChange);
//			formulaire.setType(type);
//			formulaire.setIdUser(idUser);
//			formulaire.setDateModification(dateModification);
//			formulaire.setReservation(reservationDTO);
//		chambreDTO.setFormulaire(formulaire);
//		chambreDTO.setNumeroChambre(numeroChambre);
		
//		
//		
//			Services services = new ServicesWeb();
//			assertTrue(services.update(chambreDTO));
		
		
	}

	@Test
	public void testObtenirReservations() {
		int idClient;
		
			Services services = new ServicesWeb();
			 idClient = 2;
			ReservationDTO[] liste = services.obtenirReservations(idClient);
			for(ReservationDTO dto:liste){ApplicationLineDeCommande.afficherReservation(dto);}
			assertTrue(liste.length != 0);
		
	}

}
