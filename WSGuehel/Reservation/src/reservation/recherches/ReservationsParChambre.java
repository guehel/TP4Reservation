package reservation.recherches;

import java.util.TreeSet;

import org.joda.time.DateTime;

import reservation.entites.Entite;
import reservation.objects.Chambre;
import reservation.objects.Reservation;

public class ReservationsParChambre extends RechercheReservation {

	 private Chambre chambre;	

	 public ReservationsParChambre(TreeSet<Reservation> reservations, Entite client) {
	 	super(reservations);
	 	this.chambre = (Chambre) client;
	 }

	@Override
	public TreeSet<Reservation> rechercher() {
		//utiliser le code commentet pour limiter la recherche
//		DateTime now = new DateTime();
		
		for(Reservation reservation: reservations){
			if(reservation.getChambre().equals(chambre)	
//				&&	reservation.getInterval().contains(now)
					){
				resultats.add(reservation);
			}
		}
		return resultats;
	}

}
