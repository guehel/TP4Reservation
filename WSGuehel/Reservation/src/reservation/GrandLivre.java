package reservation;

import java.util.TreeSet;

import reservation.dto.Formulaire;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Entite;
import reservation.objects.Reservation;

public interface GrandLivre {
	//Envoie une nouvelle reservation 
	public boolean reserver(Reservation reservation);

	// Liste des reservations par client ou chambre
	public TreeSet<Reservation> getReservations(Entite client);

	// Liste des reservations 
	public TreeSet<Reservation> getReservations();


	public boolean modifierChambre(Reservation reservation, int type);




}


