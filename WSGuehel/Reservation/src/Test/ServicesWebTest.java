package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.Services;
import reservation.ServicesWeb;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

public class ServicesWebTest {

	@Test
	public void testServicesWeb() {
		try {
			Services services = new ServicesWeb();
		} catch (ClassNotFoundException | SQLException e) {
			fail("Not yet implemented");
		}
		
	}

	@Test
	public void testObtenirListeChambre() {
		
		try {
			Services services = new ServicesWeb();
			ChambreDTO[] liste = services.obtenirListeChambre();
			
			System.out.println(liste.length);
			assertTrue(liste.length == 20);
			for(ChambreDTO dto: liste){
				System.out.println(dto.getNumeroChambre());
				System.out.println(dto.getFormulaire().getDateModification());
				System.out.println( "\t taille"+dto.getReservations().length);
				for(ReservationDTO resdto: dto.getReservations()){
					System.out.println("\t"+resdto.getCreation());
					System.out.println("\t"+resdto.getArrivee());
					System.out.println("\t"+resdto.getDepart());
					System.out.println("\t"+resdto.getChambreDTO().getNumeroChambre());
					System.out.println("\t"+resdto.getClientDTO().getNom());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail(" implemented");
		}
	}

	@Test
	public void testObtenirListeClients() {
		
	
	}

	@Test
	public void testUpdate() {
		ChambreDTO chambreDTO = new ChambreDTO();
		int numeroChambre=1;
			Formulaire formulaire = new Formulaire();
			int type=0;
			int idUser = 4;
			String dateModification="2010-05-01";
			ReservationDTO reservationDTO = new ReservationDTO();
				int idReservation = 113;	
				ClientDTO clientDTO = new ClientDTO();	
					int idClient = 2;
					String nom = "Martin";
					String prenom = "Paul";
					clientDTO.setId(idClient);
					clientDTO.setNom(nom);
					clientDTO.setPrenom(prenom);
				String creation = "2010-05-01";
				String arrivee = "2015-05-01";
				String depart = "2016-05-01";
				ChambreDTO chambreAChange = new ChambreDTO();
					chambreAChange.setNumeroChambre(numeroChambre);
				reservationDTO.setIdReservation(idReservation);
				reservationDTO.setClientDTO(clientDTO);
				reservationDTO.setCreation(creation);
				reservationDTO.setArrivee(arrivee);
				reservationDTO.setDepart(depart);
				reservationDTO.setChambreDTO(chambreAChange);
			formulaire.setType(type);
			formulaire.setIdUser(idUser);
			formulaire.setDateModification(dateModification);
			formulaire.setReservation(reservationDTO);
		chambreDTO.setFormulaire(formulaire);
		chambreDTO.setNumeroChambre(numeroChambre);
		
		
		try {
			Services services = new ServicesWeb();
			assertTrue(services.update(chambreDTO));
		} catch (ClassNotFoundException | SQLException e) {
			fail("Echecj modification");
			e.printStackTrace();
		}
		;
	}

	@Test
	public void testObtenirReservations() {
		int idClient;
		try {
			Services services = new ServicesWeb();
			 idClient = 3;
			ReservationDTO[] liste = services.obtenirReservations(idClient);
			assertTrue(liste.length != 0);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail(" implemented");
		}
	}

}
