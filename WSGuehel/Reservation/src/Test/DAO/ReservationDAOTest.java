package Test.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import reservation.dao.ReservationDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dto.ReservationDTO;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class ReservationDAOTest {
	
	//TODO: corriger erreurs

	@Test
	public void testReservationDAO() {
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		ReservationDAO chdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

	@Test
	public void testCreateReservation() {
		Long now = System.currentTimeMillis();
		Interval refInterval1 = new Interval(now-100000, now+100000);
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		res1.setIdChambre(idChambre1);
		res1.setCreation(new DateTime());
		res1.setIdReservation(99);
		res1.setInterval(refInterval1);
			
		res1.setClient(new Client());
		
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		resdao.create(res1);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
		
	}
	
	@Test
	public void testFindReservation() {
		Long now = System.currentTimeMillis();
		Interval refInterval1 = new Interval(now-100000, now+100000);
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		res1.setIdChambre(idChambre1);
		res1.setCreation(new DateTime());
		res1.setIdReservation(99);
		res1.setInterval(refInterval1);
			//TODO: CLEINT
		res1.setClient(new Client());
		
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		res1  = resdao.find(res1);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

	@Test
	public void testDeleteReservation() {
		Long now = System.currentTimeMillis();
		Interval refInterval1 = new Interval(now-100000, now+100000);
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		res1.setIdChambre(idChambre1);
		res1.setCreation(new DateTime());
		res1.setIdReservation(99);
		res1.setInterval(refInterval1);
			
		res1.setClient(new Client());
		
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		resdao.delete(res1);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

	

	@Test
	public void testSaveFromDTO() {
		Long now = System.currentTimeMillis();
		Interval refInterval1 = new Interval(now-100000, now+100000);
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		res1.setIdChambre(idChambre1);
		res1.setCreation(new DateTime());
		res1.setIdReservation(99);
		res1.setInterval(refInterval1);
			
		res1.setClient(new Client());
		
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		resdao.saveFromDTO(new ReservationDTO(res1));
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

}
