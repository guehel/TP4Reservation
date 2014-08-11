package reservation.recherches;



import reservation.GrandLivreHotel;
import reservation.dto.ReservationDTO;
import reservation.entites.Entite;


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
