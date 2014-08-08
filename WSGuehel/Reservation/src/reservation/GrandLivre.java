package reservation;

import java.util.TreeSet;

import reservation.objects.Client;
import reservation.objects.Reservation;

public interface GrandLivre {
	//Envoie une nouvelle reservation 
public boolean reserver(Reservation reservation);

	// Ou est la javadoc?
public TreeSet<Reservation> getReservations(Client client);
}
