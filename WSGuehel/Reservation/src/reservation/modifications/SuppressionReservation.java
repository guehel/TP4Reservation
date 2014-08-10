package reservation.modifications;

import java.sql.SQLException;

import reservation.objects.Client;
import reservation.objects.Reservation;

public class SuppressionReservation extends ModificationReservation {

	private Reservation reservation;

	public SuppressionReservation() throws ClassNotFoundException, SQLException {
		super();
	}

	@Override
	public boolean modifier(Reservation preservation) {
		this.reservation = preservation;
		boolean retour = false;
		if(valider(reservation)){
			retour = this.daoReservation.delete(reservation);
			this.reservation = null;
		}
		return retour;
	}

	@Override
	protected boolean valider(Reservation preservation) {
		boolean valide   = super.valider(preservation);

		if(valide) 
		{
			this.reservation = this.daoReservation.find(preservation);
			Client reservant = preservation.getClient();
			valide = reservation.getClient().equals(reservant);

		}
		return valide;

	}

}
