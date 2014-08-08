package Test.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;

public class DAOFactoryTest {

	@Test
	public void testDAOFactory() {
		DAOFactory fact = null;
		try{fact = new DAOFactory();}catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			e.printStackTrace();
			fail("sql error");
		}
		
	}
	
	

	@Test
	public void testGetDAO() {
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		ClientDAO cldao = (ClientDAO) fact.getDAO(Table.CLIENT);
		try{
		ReservationDAO resdao = (ReservationDAO) fact.getDAO(Table.RESERVATION);
		}catch(Exception e){e.printStackTrace();}
		ChambreDAO chdao = (ChambreDAO) fact.getDAO(Table.CHAMBRE);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
		
		
	}

}
