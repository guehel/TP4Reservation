package reservation.recherches;

import java.util.TreeSet;

import reservation.entites.Entite;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class ReservationsParClient extends RechercheReservation {
 private Client client;

public ReservationsParClient(TreeSet<Reservation> reservations, Entite client2) {
	super(reservations);
	this.client = (Client) client2;
}

@Override
public TreeSet<Reservation> rechercher() {
	
	for(Reservation reservation: reservations){
		if(reservation.getClient().equals(client)){
			resultats.add(reservation);
		}
	}
	return resultats;
}
}
