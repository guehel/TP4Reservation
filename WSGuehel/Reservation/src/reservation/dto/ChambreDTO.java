package reservation.dto;

import reservation.objects.Chambre;

public class ChambreDTO extends EntiteDTO {
	
	    private int numeroChambre;
	    private Formulaire formulaire;
	 
	    public ChambreDTO(Chambre chambre) {
	    	formulaire = new Formulaire();
	    	numeroChambre = chambre.getNumeroChambre();
	    	reservations = new ReservationDTO[chambre.getReservations().size()];
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

		public Chambre getChambre() {
			Chambre chambre = new Chambre(numeroChambre);
			
			return chambre;
		}
}
