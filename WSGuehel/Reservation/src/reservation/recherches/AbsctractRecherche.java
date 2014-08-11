package reservation.recherches;

import reservation.GrandLivreHotel;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;
import reservation.entites.Entite;


public abstract class AbsctractRecherche extends Entite implements Recherche {
	protected GrandLivreHotel grandLivre;
	

	public AbsctractRecherche(GrandLivreHotel grandLivre) {
		this.grandLivre = grandLivre;
	}


	public ReservationDTO[] rechercherReservations() {
			return null;
	}


	public ClientDTO[] rechercherClients() {
		
		return null;
	}

	
	public ChambreDTO[] rechercherChambres() {
		return null;
	}
	protected abstract void effectuerRecherche();
	}
