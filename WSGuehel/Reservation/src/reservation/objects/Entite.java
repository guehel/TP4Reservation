package reservation.objects;

import java.util.TreeSet;

/**Classe absctraite pour factorise le code de traitement des set de reservation
 * @author boug18087415
 *
 */
public abstract class Entite {
	 protected TreeSet<Reservation> reservations;
	 public Entite(){
			reservations = new TreeSet<Reservation>(new ComparateurReservation()	
					);
	 }
	public TreeSet<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(TreeSet<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	public void ajouterReservation(Reservation reservation){
		reservations.add(reservation);
	}
	
	public void supprimerReservation(Reservation reservation){
		reservations.remove(reservation);
	}
	 
}
