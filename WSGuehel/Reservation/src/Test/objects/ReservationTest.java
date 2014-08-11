package Test.objects;

import static org.junit.Assert.*;

import org.joda.time.Interval;
import org.junit.Test;

import reservation.objects.Chambre;
import reservation.objects.Reservation;

public class ReservationTest {

	@Test
	public void testHashCode() {
		fail();

	}

	@Test
	public void testEqualsObject() throws Exception {
		Long now = System.currentTimeMillis();

		Interval refInterval1 = new Interval(now-10000, now+10000);
		Interval interval2 = new Interval(now-10000, now+10000);
		Interval interval3 = new Interval(now-5000, now+4999);
		Interval interval4 = new Interval(now-9999, now+10000);
		Interval interval5 = new Interval(now-20000, now-11000);
		Interval interval6 = new Interval(now+11000, now+20000);
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		res1.setChambre(new Chambre());
		Reservation res2 = new Reservation();
		int idChambre2= 2;
		
		res2.setChambre(new Chambre());
				
		assertFalse(res1.equals(res2));
		
		res1.setInterval(refInterval1);
		res2.setInterval(refInterval1);
		assertTrue(res1.equals(res2));
		
		res2.setChambre(new Chambre());
		assertFalse(res1.equals(res2));
		
		res2.setChambre(new Chambre());
		
		res2.setInterval(interval2);
		assertTrue(res1.equals(res2));
		
		res2.setInterval(interval3);
		assertTrue(res1.equals(res2));
		
		res2.setInterval(interval4);
		assertTrue(res1.equals(res2));
		
		res2.setInterval(interval5);
		assertFalse(res1.equals(res2));
		
		res2.setInterval(interval6);
		assertFalse(res1.equals(res2));
	}

}
