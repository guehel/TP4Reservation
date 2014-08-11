package reservation.recherches;




import reservation.GrandLivreHotel;
import reservation.entites.Entite;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class ReservationsParClient extends RechercheReservation {
 private Client client;

public ReservationsParClient(GrandLivreHotel grandLivre, Entite client2) {
	super(grandLivre);
	this.client = (Client) client2;
}


@Override
protected void effectuerRecherche() {
	
	for(Reservation reservation: grandLivre.getReservations()){
		if(reservation.getClient().equals(client)){
		this.reservations.add(reservation);
		
		}
	}
	
}
}
