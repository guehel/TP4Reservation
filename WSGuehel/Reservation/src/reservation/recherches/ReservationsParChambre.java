package reservation.recherches;



import reservation.GrandLivreHotel;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.objects.Chambre;
import reservation.objects.Reservation;

public class ReservationsParChambre extends RechercheReservation {

	private Chambre chambre;	

	public ReservationsParChambre(GrandLivreHotel grandLivre, Chambre client) {
		super(grandLivre);
		this.chambre = (Chambre) client;
	}
	
	public ReservationsParChambre(GrandLivreHotel grandLivre) {
		super(grandLivre);
	
	}

	
	public void setChambre(Chambre chambre) {
		this.chambre = chambre;
	}

	@Override
	protected void effectuerRecherche(){
	
		for(Reservation reservation: grandLivre.getReservations()){
			if(reservation.getChambre().equals(chambre)	
					//				&&	reservation.getInterval().contains(now)
					){
			this.reservations.add(reservation);
			}
		}
	}

	
	

}
