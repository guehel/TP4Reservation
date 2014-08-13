package reservation.dto;

import reservation.objects.Chambre;

public abstract class ChambreDTO {
	private int numeroChambre=0;
  
 
    public ChambreDTO(Chambre chambre) {
    
    	numeroChambre = chambre.getNumeroChambre();

	}
    
    public ChambreDTO() {
		super();
	}

	public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

//	reservations = new ReservationDTO[chambre.getNombreReservation()];

    public abstract Formulaire getFormulaire();    
    public abstract void setFormulaire(Formulaire formulaire);
	public abstract reservation.dto.ReservationDTO[] getReservations();
	public abstract void setReservations(reservation.dto.ReservationDTO[] reservations) ;
}
