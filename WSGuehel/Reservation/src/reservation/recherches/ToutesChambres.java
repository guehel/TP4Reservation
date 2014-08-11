package reservation.recherches;

import reservation.GrandLivreHotel;
import reservation.dto.ChambreDTO;
import reservation.dto.ReservationDTO;
import reservation.entites.EntiteChambre;
import reservation.objects.Chambre;



public class ToutesChambres extends RechercheChambres {
	private Recherche rechercheReservation = null;
	public ToutesChambres(GrandLivreHotel grandLivre) {
		super(grandLivre);
		
	}

	@Override
	protected void effectuerRecherche() {
	
		this.listeChambreDTOs = new ChambreDTO[grandLivre.getListeChambre().size()];
		int i=0;
		
		for(Chambre chambre : grandLivre.getListeChambre()){
			
			this.listeChambreDTOs[i] = new EntiteChambre(chambre).getChambreDTO();
			rechercheReservation = RechercheFactory.getRechercheReservation(chambre);
			ReservationDTO[] reservationsChambre = rechercheReservation.rechercherReservations();
			this.listeChambreDTOs[i].setReservations(reservationsChambre);
			
			i++;
		}


	}

}
