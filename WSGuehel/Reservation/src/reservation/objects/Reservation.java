package reservation.objects;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import reservation.dao.OutilsDates;

public class Reservation {
	
	    private Client client;

	    private DateTime creation;

	    private Interval interval;

	    private Chambre chambre;

	    private int idReservation;

		

		public DateTime getCreation() {
			return creation;
		}

		public void setCreation(DateTime creation) {
			this.creation = creation;
		}

		public Interval getInterval() {
			return interval;
		}

		public void setInterval(Interval interval) throws Exception {
			if (interval.getStart().isAfterNow())
			this.interval = interval;
			else throw new Exception("la reservation commence avant aujoud'hui ");
		}

		public Client getClient() {
			return client;
		}

		public void setClient(Client client) {
			this.client = client;
		}

	

		public Chambre getChambre() {
			return chambre;
		}

		public void setChambre(Chambre idChambre) {
			this.chambre = idChambre;
		}

		public int getIdReservation() {
			return idReservation;
		}

		public void setIdReservation(int idReservation) {
			this.idReservation = idReservation;
		}

		@Override
		public boolean equals(Object obj) {
			Reservation resa = (Reservation) obj;
			boolean retour = OutilsDates.CompareInterval(interval, resa.getInterval()) 
					&& chambre.equals(resa.getChambre());
			return retour;
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}
		
		public boolean validerDates(DateTime avant, DateTime apres){
			boolean valide = false;
			if(avant!=null && apres!=null ){
				valide = avant.isBefore(apres) || avant.isEqual(apres);
			}
				return valide;
		}
	    
		
	    
}
