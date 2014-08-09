package reservation.objects;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import reservation.dao.OutilsDates;

public class Reservation implements Comparable<Reservation> {
	
	    private Client client;

	    private DateTime creation;

	    private Interval interval;

	    private Chambre chambre;

	    private int idReservation;

		

		public DateTime getCreation() {
			return creation;
		}

		public void setCreation(DateTime creation) {
			if (interval==null || validerDates(creation, interval.getStart()))
			this.creation = creation;
		}

		public Interval getInterval() {
			return interval;
		}

		public void setInterval(Interval interval) throws Exception {
			if (creation==null || validerDates(creation, interval.getStart()))
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
		//adds the specified element e to this set
		//if the set contains no element e2 such that (e==null ? e2==null : e.equals(e2)).
		@Override
		public boolean equals(Object obj) {
			Reservation resa = (Reservation) obj;
			boolean retour = interval.abuts(resa.getInterval())
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

		@Override
		public int compareTo(Reservation o) {
			//verifier si les 2 intervals se touchent
			boolean isDisjoint = !this.getInterval().abuts( o.getInterval());
			int disjoint = isDisjoint? 1:0;
			// Calcule le numchambre * debut 
			Long debut = this.getInterval().getStartMillis()/3600 * this.getChambre().getNumeroChambre();
			Long fin =  o.getInterval().getStartMillis()/3600 * o.getChambre().getNumeroChambre();
			// pour une meme chambre retourne 0, si les intervals ne sont pas disjoint
			//retour = (numchambre * debut - numchambre * debut) * disjoint
			return (int) (fin - debut)*disjoint;
		}
	    
		
	    
}
