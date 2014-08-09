package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.Services;
import reservation.ServicesWeb;
import reservation.dto.ChambreDTO;
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
				System.out.println( "\t taille"+dto.getReservations().length);
				for(ReservationDTO resdto: dto.getReservations()){
					System.out.println("\t"+resdto.getCreation());
					System.out.println("\t"+resdto.getArrivee());
					System.out.println("\t"+resdto.getDepart());
					System.out.println("\t"+resdto.getChambreDTO().getNumeroChambre());
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			fail(" implemented");
		}
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
			e.printStackTrace();
			fail(" implemented");
		}
	}

}
