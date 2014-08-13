package reservation.dto;

import reservation.objects.Chambre;

public class ChambreDTODB extends ChambreDTO {
	
	   

		public ChambreDTODB(Chambre chambre) {
		// TODO Auto-generated constructor stub
			super(chambre);
	}

		public ChambreDTODB() {
			// TODO Auto-generated constructor stub
		}

		@Override
		public ReservationDTO[] getReservations() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void setReservations(ReservationDTO[] reservations) {
			// TODO Auto-generated method stub
			
		}

		public void setFormulaire(Formulaire formulaire) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Formulaire getFormulaire() {
			// TODO Auto-generated method stub
			return null;
		}

	
}
