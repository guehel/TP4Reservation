package reservation.dto;

import reservation.objects.Chambre;

public  class ChambreDTO {
	private int numeroChambre;
//	protected Formulaire formulaire;
 
    public ChambreDTO(Chambre chambre) {
    
    	numeroChambre = chambre.getNumeroChambre();

	}
    
   

	public ChambreDTO() {
		numeroChambre = 0;
	}



	public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }


//    public  Formulaire getFormulaire() {
//		return formulaire;
//	}    
//    public  void setFormulaire(Formulaire formulaire) {
//    	this.formulaire = formulaire;
//	}
	public  reservation.dto.ReservationDTO[] getReservations() {
		return null;
	}
	public  void setReservations(reservation.dto.ReservationDTO[] reservations) {
	}
}
