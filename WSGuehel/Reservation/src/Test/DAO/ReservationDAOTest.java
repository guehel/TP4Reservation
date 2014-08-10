package Test.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import reservation.dao.ClientDAO;
import reservation.dao.ReservationDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;
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
	public void testSaveFromDTO() {
	
		ReservationDTO res1 = new ReservationDTO();
		
		res1.setArrivee("2014-07-01");
		res1.setCreation("2014-06-01");
		res1.setDepart("2014-09-01");
		res1.setIdReservation(99);
		
			
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId(1);
		
		res1.setClientDTO(clientDTO);
		
		ChambreDTO chambre =new ChambreDTO();
		chambre.setNumeroChambre(5);
		res1.setChambreDTO(chambre);
		
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		ClientDAO cltdao = (ClientDAO) fact.getDAO(Table.CLIENT);
		Client client = cltdao.findById(2);
		res1.setClientDTO(new ClientDTO(client));
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		resdao.saveFromDTO(res1);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}


//	@Test
//	public void testCreateReservation() {
//		DateTime now = new DateTime();
//		
//		
//		Reservation rervation = new Reservation();
//		rervation.setIdReservation(99);
//		
//		Chambre chambre1= new Chambre();	
//		chambre1.setNumeroChambre(1);
//		rervation.setChambre(chambre1);
//		
//		rervation.setCreation(new DateTime());
//		
//		Interval refInterval1 = new Interval(now.minusDays(2), now.plusDays(3));
//		rervation.setInterval(refInterval1);
//		
//		Client client = new Client();
//		client.setIdClient(1);
//		rervation.setClient(new Client());
//		
//		DAOFactory fact = null;
//		try{
//		fact = new DAOFactory();
//		
//		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
//		assertTrue(resdao.create(rervation));
//		}
//		catch(ClassNotFoundException e ){
//			fail("driver error ");
//		} catch (SQLException e) {
//			fail("sql error");
//		}
//		
//	}
	
	@Test
	public void testFindReservation() {
		
		Reservation res1 = null;
		
		
	
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		res1  = resdao.findByIds(99, 1);
		
		assertTrue(res1.getIdReservation()==99);
		res1  = resdao.find(res1);
		
		assertTrue(res1.getIdReservation()==99);
		
		assertTrue(resdao.delete(res1));
		TreeSet<Reservation> resss = resdao.getAllReservations();
		for (Reservation resa :resss){
			System.out.println(resa.getIdReservation());
			System.out.println(resa.getChambre().getNumeroChambre());
			System.out.println(resa.getCreation());
			System.out.println(resa.getInterval());
			System.out.println(resa.getClient().getIdClient());
		}
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

	@Test
	public void testDeleteReservation() {
//		Reservation res1 = null;
//		
//	
//	
//		DAOFactory fact = null;
//		try{
//		fact = new DAOFactory();
//		
//		
//		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
//		
//		res1  = resdao.findByIds(99, 1);
//		
//		assertTrue(res1.getIdReservation()==99);
//		
//		assertTrue(resdao.delete(res1));
//		
//		}
//		catch(ClassNotFoundException e ){
//			fail("driver error ");
//		} catch (SQLException e) {
//			fail("sql error");
//		}
	}

	

}
