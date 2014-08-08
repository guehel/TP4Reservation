package Test.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.dao.ChambreDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;

public class ChambreDAOTest {

	@Test
	public void testChambreDAO() {
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		ChambreDAO chdao = (ChambreDAO) fact.getDAO(Table.CHAMBRE);
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
	}

	@Test
	public void testCreateChambre() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteChambre() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindChambre() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateDTO() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreateFromDTO() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAllChambres() {
		fail("Not yet implemented");
	}

}
