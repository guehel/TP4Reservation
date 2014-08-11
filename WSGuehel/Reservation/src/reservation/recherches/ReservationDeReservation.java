package reservation.recherches;



import reservation.GrandLivreHotel;
import reservation.dto.ReservationDTO;
import reservation.objects.Reservation;


public class ReservationDeReservation extends RechercheReservation {

	private Reservation reservation;	

	public ReservationDeReservation(GrandLivreHotel grandLivre, Reservation reservation) {
		super(grandLivre);
		this.reservation = (Reservation) reservation;
	}
	
	public ReservationDeReservation(GrandLivreHotel grandLivre) {
		super(grandLivre);	
	
	}

	
	@Override
	protected void effectuerRecherche(){
	
		for(Reservation reservation: grandLivre.getReservations()){
			if(reservation.equals(reservation)				
					){
			this.reservations.add(reservation);
			}
		}
	}

	
	

}
