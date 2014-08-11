package reservation.recherches;



import reservation.GrandLivreHotel;
import reservation.dto.ReservationDTO;



public abstract class RechercheReservation extends AbsctractRecherche {

	public RechercheReservation(GrandLivreHotel grandLivre) {
		super(grandLivre);
		
	}

	

	
	@Override
	public ReservationDTO[] rechercherReservations() {
		
		effectuerRecherche();
		return super.getReservationsArray();
	}



	

	

}
