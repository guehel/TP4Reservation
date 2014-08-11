package Test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.junit.Test;

import reservation.GrandLivre;
import reservation.GrandLivreHotel;
import reservation.dao.ClientDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.entites.Entite;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class GrandLivreHotelTest {

	@Test
	public void testGrandLivreHotel() {
		GrandLivreHotel grandLivre = new GrandLivreHotel();
		assert(grandLivre.isValide());
	}



	@Test
	public void testGetReservationsClient() {
//		
//		try{
//		
//		GrandLivreHotel grandLivre = new GrandLivreHotel();
//		
//		TreeSet<Reservation> listeReservatons= grandLivre.getReservations(client );
//		for(Reservation reservation:listeReservatons ){
//			System.out.println(reservation);
//		}
//		assertTrue("nombre de reservation"+listeReservatons.size(), listeReservatons.size()!=0);
//		}
//		catch(ClassNotFoundException e ){
//			fail("driver error ");
//		} catch (SQLException e) {
//			fail("sql error");
//		}
	}

}
