package reservation.objects;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import reservation.dao.OutilsDates;
import reservation.dto.ReservationDTO;
import reservation.entites.EntiteChambre;
import reservation.entites.EntiteClient;

public class Reservation implements Comparable<Reservation> {
	
	    private Client client;

	    private DateTime creation;

	    private Interval interval;

	    private Chambre chambre;

	    private int idReservation;

	    public Reservation() {
			super();
			
		}

		public Reservation( Chambre chambre) {
			super();
			this.creation = new DateTime();
			this.chambre = chambre;
		}
		
		

		public Reservation( ReservationDTO reservationDto) throws Exception {

			 DateTime dateCreation = OutilsDates.stringToJodaDate(reservationDto.getCreation());
			 DateTime dateArrivee = OutilsDates.stringToJodaDate(reservationDto.getArrivee());
			 DateTime dateDepart = OutilsDates.stringToJodaDate(reservationDto.getDepart());
			 
			
			 this.setIdReservation(reservationDto.getIdReservation());
			 EntiteChambre entiteChambre = new EntiteChambre();
			 entiteChambre.setFromChambreDTO(reservationDto.getChambreDTO());
			 this.setChambre( entiteChambre.getChambre());
			 EntiteClient entiteClient = new EntiteClient();
			 entiteClient.setClientFromDTO(reservationDto.getClientDTO());
			 this.setClient(entiteClient.getClient());
			 this.setCreation(dateCreation);
			 this.setInterval(new Interval(dateArrivee, dateDepart));
		}



		public Reservation(Client client, DateTime creation, Interval interval,
				Chambre chambre, int idReservation) {
			super();
			this.client = client;
			this.creation = creation;
			this.interval = interval;
			this.chambre = chambre;
			this.idReservation = idReservation;
		}


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
			boolean retour = chambre.equals(resa.getChambre()); System.out.println("meme chambre: "+(retour? 'V' :'F'));
					
					;retour = retour	&&  interval.overlaps(resa.getInterval()); 
					System.out.println(interval+ " chevauche ch "+resa.getInterval()+": "+(retour? 'V' :'F'));
					
				 //retour = memeChambre && chevauche 
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

		@Override
		public String toString() {
			return "Reservation [client=" + client + ", creation=" + creation
					+ ", interval=" + interval + ", chambre=" + chambre.getNumeroChambre()
					+ ", idReservation=" + idReservation + "]";
		}

	
		public boolean isValide() {
		if(client==null) return false;
		else if (chambre == null) return false;
		else if (interval == null) return false;
		else if (creation == null) return false;
		else if (interval.getStart().isBefore(creation)) return false;
		else return true;
		}
		
	    
}
