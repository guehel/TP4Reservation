package reservation.entites;

import reservation.dto.ReservationDTO;

public interface EntiteInterface {
	ReservationDTO[] getReservationsArray();
	void setReservationsFromDTO(ReservationDTO[] reservationsDTO);
}
