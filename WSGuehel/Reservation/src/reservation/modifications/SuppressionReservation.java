package reservation.modifications;

import java.sql.SQLException;

import reservation.GrandLivreHotel;
import reservation.dto.ReservationDTO;
import reservation.entites.EntiteReservation;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class SuppressionReservation extends ModificationReservation {

	

	public SuppressionReservation(GrandLivreHotel grandLivre) throws ClassNotFoundException, SQLException {
		super(grandLivre);
	}

	@Override
	public boolean modifier(ReservationDTO reservationDTO) {
		boolean valide = reservationDTO!=null;
		if (valide) {
			EntiteReservation entite = new EntiteReservation();
			try {
				entite.setReservationFromDTO(reservationDTO);
				Reservation reservation = entite.getReservation();

				if (valider(reservation)) {
					valide = this.daoReservation.delete(reservation);
					if (valide)
						this.grandLivre.supprimerReservation(reservation);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valide;
	}

	@Override
	protected boolean valider(Reservation preservation) {
		boolean valide   = super.valider(preservation);
		if(valide) 
		{	Client reservant = preservation.getClient();
			Reservation reservation = this.grandLivre.getReservation(preservation);
			valide = reservation.getClient().equals(reservant);
			
		}
		return valide;
	}

}
