package reservation.entites;

import java.util.Iterator;
import java.util.TreeSet;

import reservation.dto.ReservationDTO;

import reservation.objects.Reservation;

/**Classe absctraite pour factorise le code de traitement des set de reservation
 * @author boug18087415
 *
 */
public abstract class Entite {
	 protected TreeSet<Reservation> reservations;
	 public Entite(){
			reservations = new TreeSet<Reservation>(	
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

			dto = new EntiteReservation(res).getReservationDTO();

			array[i] = dto;
			i++;
		}
		return array;
	}
	public void setReservationsFromDTO(ReservationDTO[] reservationsDTO) {
		EntiteReservation entiteReservation  = new EntiteReservation();
		for(ReservationDTO reservationDTO: reservationsDTO){
			try {
				entiteReservation.setReservationFromDTO(reservationDTO);
				reservations.add(entiteReservation.getReservation());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	public Reservation getReservation(Reservation parametreRecheche) {
		Reservation foundReservation;
		if (parametreRecheche!=null) {
			foundReservation = null;
			Iterator<Reservation> iterator = reservations.iterator();
			while (iterator.hasNext() && parametreRecheche == null) {
				foundReservation = iterator.next();
				if (foundReservation.equals(parametreRecheche))
					parametreRecheche = foundReservation;
				else
					parametreRecheche = null;
			}
		}
		return parametreRecheche;
		
		
	}
	 
}
