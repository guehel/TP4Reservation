package Test.DTO;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import reservation.dto.ReservationDTO;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class ReservationDTOTest {

	@Test
	public void testReservationDTO() {
		Long now = System.currentTimeMillis();

		Interval refInterval1 = new Interval(now-10000, now+10000);
		
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		res1.setIdChambre(idChambre1);
		res1.setInterval(refInterval1);
		//TODO: modif param Client
		res1.setClient(new Client());
		res1.setCreation(new DateTime());
		ReservationDTO dto = new ReservationDTO(res1);
		System.out.println(dto.getArrivee());
		System.out.println(dto.getDepart());
		System.out.println(dto.getCreation());
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
