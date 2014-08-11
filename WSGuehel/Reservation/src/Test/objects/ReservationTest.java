package Test.objects;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.junit.Test;

import reservation.objects.Chambre;
import reservation.objects.Reservation;

public class ReservationTest {


	@Test
	public void testEqualsObject() throws Exception {
		DateTime now = new DateTime();

		Interval cetteSemaine = new Interval(now, now.plusDays(7));
		Interval memeSemaine =  new Interval(now, now.plusDays(7));
		Interval semainePasse = new Interval(now.minusDays(7), now.plusDays(14));
		Interval semaineProchaine = new Interval(now.plusDays(3), now.plusDays(14));
		Interval semainesAvant = new Interval(now.minusDays(7), now.minusDays(1));
		Interval semainesApres = new Interval(now.plusDays(8), now.plusDays(15));
		
		Reservation resReference = new Reservation();
		Chambre chambre1= new Chambre(1);
		Chambre chambre2= new Chambre(2);
		
		resReference.setChambre(chambre1);
		
		Reservation resaTest = new Reservation();
		resaTest.setChambre(chambre1);
		
		resReference.setCreation(now.minusDays(30));
		resaTest.setCreation(now.minusDays(30));
		
//		assertFalse(resReference.equals(resaTest));
		
		resReference.setInterval(cetteSemaine);
		resaTest.setInterval(cetteSemaine);
		assertTrue(resReference.equals(resaTest));
		
		resaTest.setChambre(chambre2);
		assertFalse(resReference.equals(resaTest));
		
		resaTest.setChambre(chambre1);
		
		resaTest.setInterval(memeSemaine);
		assertTrue(resReference.equals(resaTest));
	
		resaTest.setInterval(semainePasse);
		assertTrue(resReference.equals(resaTest));
		
		resaTest.setInterval(semaineProchaine);
		assertTrue(resReference.equals(resaTest));
		
		resaTest.setInterval(semainesAvant);
		assertFalse(resReference.equals(resaTest));
		
		resaTest.setInterval(semainesApres);
		assertFalse(resReference.equals(resaTest));
	}

}
