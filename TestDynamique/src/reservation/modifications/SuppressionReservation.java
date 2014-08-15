package reservation.modifications;

import reservation.SingleGrandLivre;
import reservation.dto.ReservationDTO;

public class SuppressionReservation extends ModificationReservation {

	@Override
	public boolean modifier(ReservationDTO reservationDTO) {
		boolean valide = SingleGrandLivre.getInstance().effectuerSuppression(
				reservationDTO);
		return valide;
	}

}
