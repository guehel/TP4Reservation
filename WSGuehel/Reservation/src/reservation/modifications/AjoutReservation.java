package reservation.modifications;

import java.sql.SQLException;

import reservation.GrandLivreHotel;
import reservation.dto.ReservationDTO;
import reservation.entites.EntiteReservation;
import reservation.objects.Reservation;

public class AjoutReservation extends ModificationReservation {

	public AjoutReservation(GrandLivreHotel grandLivre)
			throws ClassNotFoundException, SQLException {
		super(grandLivre);

	}

	@Override
	public boolean modifier(ReservationDTO reservationDTO) {
		boolean retour = false;
		EntiteReservation entite = new EntiteReservation();
		try {
			entite.setReservationFromDTO(reservationDTO);
			Reservation reservation = entite.getReservation();
			if (valider(reservation)) {
				if (!this.grandLivre.contains(reservation))
					retour = this.daoReservation.create(reservation);
				if (retour)
					this.grandLivre.ajouterReservation(reservation);
				;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retour;
	}

}
