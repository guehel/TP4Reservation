package Test.DTO;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import reservation.dto.ReservationDTO;
import reservation.entites.EntiteReservation;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class ReservationDTOTest {

	@Test
	public void testReservationDTO() throws Exception {
		Client client =  new Client();
		client.setIdClient(1);
		client.setNom("PAUPOL");
		client.setPrenom("Prenomo");
		DateTime now = new DateTime();

		Interval refInterval1 = new Interval(now.minusDays(2), now.plusDays(3));
		
		Reservation res1 = new Reservation();
		res1.setIdReservation(1);
		int idChambre1= 1;
		Chambre  chambre = new Chambre();
		chambre.setNumeroChambre(idChambre1);
		res1.setChambre(chambre);
		res1.setInterval(refInterval1);
		
		res1.setClient(client);
		res1.setCreation(new DateTime());
		EntiteReservation eResa = new EntiteReservation(res1);
		ReservationDTO dto = eResa.getReservationDTO();
		
		System.out.println(dto.getArrivee());
		System.out.println(dto.getDepart());
		System.out.println(dto.getCreation());
		System.out.println(dto.getChambreDTO().getNumeroChambre());
		System.out.println(dto.getClientDTO().getId());
		System.out.println("nom "+dto.getClientDTO().getNom());
		System.out.println("Pnom "+dto.getClientDTO().getPrenom());
//		assertTrue(dto.getClientDTO()==99);
	}

	@Test
	public void testReservationDTOStringClientDTOStringStringIntInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testReservationDTOReservation() {
		fail("Not yet implemented");
	}

}
