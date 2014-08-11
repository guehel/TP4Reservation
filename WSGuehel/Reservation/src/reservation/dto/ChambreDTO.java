package reservation.dto;

import reservation.objects.Chambre;

public class ChambreDTO extends EntiteDTO {
	
	    private int numeroChambre;
	    private Formulaire formulaire;
	 
	    public ChambreDTO(Chambre object) {
	    	formulaire = new Formulaire();
	    	numeroChambre = object.getNumeroChambre();
	    	reservations = new ReservationDTO[object.getReservations().size()];
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

	  

	    public Formulaire getFormulaire() {
	        return formulaire;
	    }

	    public void setFormulaire(Formulaire formulaire) {
	        this.formulaire = formulaire;
	    }
}
