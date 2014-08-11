package reservation.recherches;



import reservation.GrandLivreHotel;
import reservation.objects.Reservation;


public class ReservationDeReservation extends RechercheReservation {

	private Reservation pReservation;	

	public ReservationDeReservation(GrandLivreHotel grandLivre, Reservation reservation) {
		super(grandLivre);
		this.pReservation = (Reservation) reservation;
	}
	
	public ReservationDeReservation(GrandLivreHotel grandLivre) {
		super(grandLivre);	
	
	}

	
	@Override
	protected void effectuerRecherche(){
	
		for(Reservation reservation: grandLivre.getReservations()){
			if(reservation.equals(this.pReservation)				
					){
			this.reservations.add(reservation);
			}
		}
	}

	
	

}
