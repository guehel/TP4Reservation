package reservation.modifications;

import reservation.SingleGrandLivre;
import reservation.dto.ReservationDTO;

public class AjoutReservation extends ModificationReservation {

	@Override
	public boolean modifier(ReservationDTO reservationDTO) {

		boolean retour = SingleGrandLivre.getInstance().effectuerAJout(
				reservationDTO);

		return retour;
	}

}
