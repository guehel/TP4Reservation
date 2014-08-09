package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.Test;

import reservation.GrandLivre;
import reservation.GrandLivreHotel;
import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAOFactory;
import reservation.dao.ReservationDAO;
import reservation.dao.DAOFactory.Table;
import reservation.objects.Entite;
import reservation.objects.Reservation;

public class GrandLivreHotelTest {

	@Test
	public void testGrandLivreHotel() {
		fail("Not yet implemented");
	}

	@Test
	public void testReserver() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetReservationsClient() {
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		ClientDAO cldao = (ClientDAO) fact.getDAO(Table.CLIENT);
		Entite client = cldao.findById(2);
		GrandLivre grandLivre = new GrandLivreHotel();
		
		TreeSet<Reservation> listeReservatons= grandLivre.getReservations(client );
		for(Reservation reservation:listeReservatons ){
			System.out.println(reservation);
		}
		assertTrue("nombre de reservation"+listeReservatons.size(), listeReservatons.size()!=0);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

}
