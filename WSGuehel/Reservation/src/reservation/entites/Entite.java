package reservation.entites;

import java.util.TreeSet;

import reservation.dto.ReservationDTO;
import reservation.objects.ComparateurReservation;
import reservation.objects.Reservation;

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
	
	public ReservationDTO[] getReservationsArray()
			 {
		int n = reservations.size();
		ReservationDTO dto  = null;
		ReservationDTO[] array = new ReservationDTO[n] ;
		
		int i = 0;
		for(Reservation res :  reservations){

			dto = new ReservationDTO(res);

			array[i] = dto;
			i++;
		}
		return array;
	}
	 
}
