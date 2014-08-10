package reservation.recherches;

import java.util.TreeSet;

import reservation.entites.Entite;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;


public class RechercheFactory extends Entite{
	public  RechercheFactory(TreeSet<Reservation> reservations){
		this.reservations = reservations;
	}	
	public RechercheReservation  getRechercheReservation(Entite client){
		if(Client.class.equals(client.getClass()))
		return new ReservationsParClient(reservations, client);
		else if(Chambre.class.equals(client.getClass()))
			return new ReservationsParChambre(reservations, client);
		else return null;
	}
	

}
