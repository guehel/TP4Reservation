package reservation.modifications;

import reservation.dto.ReservationDTO;


public interface Modification{
 boolean modifier(ReservationDTO reservationDTO);
}
