package Test.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import reservation.dao.ChambreDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;

import reservation.objects.Chambre;

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

//	@Test
//	public void testCreateChambre() {
//		Chambre chambre = new Chambre();
//		chambre.setNumeroChambre(92);
//		
//		Chambre chambre2 = new Chambre();
//		chambre2.setNumeroChambre(93);
//		ChambreDTO chdto = new ChambreDTO(chambre2);
//		
//		DAOFactory fact = null;
//		try{
//		fact = new DAOFactory();
//		ChambreDAO chambredao = (ChambreDAO) fact.getDAO(Table.CHAMBRE);
//		
//		chambredao.findByNumeroChambre(92);
//		assertTrue(chambredao.create(chambre));
//		assertTrue(chambredao.createFromDTO(chdto));
//		
//		}
//		catch(ClassNotFoundException e ){
//			fail("driver error ");
//		} catch (SQLException e) {
//			fail("sql error");
//		}
//	}

	@Test
	public void testDeleteChambre() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindChambre() {
		DAOFactory fact = null;
		try{
		fact = new DAOFactory();
		ChambreDAO chambredao = (ChambreDAO) fact.getDAO(Table.CHAMBRE);
		Chambre chambre = chambredao.findByNumeroChambre(2);
		assertTrue(chambre.getNumeroChambre()==2);
		
		}
		catch(ClassNotFoundException e ){
			fail("driver error ");
		} catch (SQLException e) {
			fail("sql error");
		}
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
