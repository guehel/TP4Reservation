package reservation.dto;



public  class EntiteDTO {
	protected reservation.dto.ReservationDTO[] reservations;

	public  EntiteDTO(){
		
	}
	
	
	public EntiteDTO(ReservationDTO[] reservations) {
		super();
		this.reservations = reservations;
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
