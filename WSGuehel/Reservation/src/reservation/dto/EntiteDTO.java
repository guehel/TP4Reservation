package reservation.dto;

import java.util.TreeSet;

import reservation.objects.Reservation;

public abstract class EntiteDTO {
	protected reservation.dto.ReservationDTO[] reservations;

	public  EntiteDTO(){
		
	}
	
	
	public EntiteDTO(ReservationDTO[] reservations) {
		super();
		this.reservations = reservations;
	}

//TODO: a supprimer
	public static  ReservationDTO[] getReservationsFromSet(
			TreeSet<Reservation> reservations2) {
		int n = reservations2.size();
		ReservationDTO dto  = null;
		ReservationDTO[] array = new ReservationDTO[n] ;
		
		int i = 0;
		for(Reservation res :  reservations2){

			dto = new ReservationDTO(res);

			array[i] = dto;
			i++;
		}
		return array;
	}

	
	 /**
     * Gets the reservations value for this ClientDTO.
     * 
     * @return reservations
     */
    public reservation.dto.ReservationDTO[] getReservations() {
        return reservations;
    }


    /**
     * Sets the reservations value for this ClientDTO.
     * 
     * @param reservations
     */
    public void setReservations(reservation.dto.ReservationDTO[] reservations) {
        this.reservations = reservations;
    }
}
