package Test.objects;

import static org.junit.Assert.*;

import org.joda.time.Interval;
import org.junit.Test;

import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Entite;
import reservation.objects.Reservation;

public class EntiteTest {

	@Test
	public void test() throws Exception {
		Long now = System.currentTimeMillis();

		Interval refInterval1 = new Interval(now-10000, now+10000);
		Interval avant = new Interval(now-20000, now-11000);
		Interval apres = new Interval(now+11000, now+20000);
		Interval encours = new Interval(now-5000, now+4999);
		
		Reservation res1 = new Reservation();
		int idChambre1= 1;
		//changer en client
		res1.setChambre(new Chambre());
		res1.setInterval(refInterval1);
		
		Reservation respendant = new Reservation();
		
		respendant.setChambre(new Chambre());
		respendant.setInterval(refInterval1);
		
		Reservation resEncours = new Reservation();
		
		resEncours.setChambre(new Chambre());
		resEncours.setInterval(encours);
		
		Reservation resApres = new Reservation();
		
		resApres.setChambre(new Chambre());
		resApres.setInterval(apres);
		
		Reservation resAvant = new Reservation();
		
		resAvant.setChambre(new Chambre());
		resAvant.setInterval(avant);
		//TODO: ADAPTER POUR LE GRAND LIVRE
//		Entite client = new Client();
//		
//		client.ajouterReservation(res1);
//		
//		assertTrue(client.getReservations().size()==1);
//		
//		client.ajouterReservation(respendant);
//		
//		assertTrue(client.getReservations().size()==1);
//		
//
//		client.ajouterReservation(resApres);
//		
//		assertTrue(client.getReservations().size()==2);
//		
//
//		client.ajouterReservation(resAvant);
//		
//		assertTrue(client.getReservations().size()==3);
//		
//		client.ajouterReservation(resEncours);
//		
//		assertTrue(client.getReservations().size()==3);
		

		
	}

}
