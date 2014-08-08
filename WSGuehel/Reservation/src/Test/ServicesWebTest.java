package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.Services;
import reservation.ServicesWeb;
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
		fail("Not yet implemented");
	}

	@Test
	public void testObtenirListeClients() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
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
			fail(" implemented");
		}
	}

}
