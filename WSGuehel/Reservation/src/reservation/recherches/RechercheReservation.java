package reservation.recherches;



import reservation.GrandLivreHotel;
import reservation.dto.ReservationDTO;



public abstract class RechercheReservation extends AbsctractRecherche {

	protected ReservationDTO[] resultats = null ;
			
	public RechercheReservation(GrandLivreHotel grandLivre) {
		super(grandLivre);
		
	}

	

	
	@Override
	public ReservationDTO[] rechercherReservations() {
		
		effectuerRecherche();
		if(resultats==null)  resultats = new ReservationDTO[0];
		return resultats;
	}



	

	

}
