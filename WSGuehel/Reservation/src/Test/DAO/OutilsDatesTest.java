package Test.DAO;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.Test;

import reservation.dao.OutilsDates;

public class OutilsDatesTest {

	@Test
	public void testJodaToSqlDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testToJodaInterval() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareInterval() {
		fail("Not yet implemented");
	}

	@Test
	public void testCompareEntreInterval() {
		fail("Not yet implemented");
	}

	@Test
	public void testStringToSqlDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testStringToJodaDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testStringFromDateTime() {
		DateTime dateTime = new DateTime(System.currentTimeMillis());
		try{
		System.out.println(OutilsDates.stringFromDateTime(dateTime));
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented");
		}
		
	}

}
