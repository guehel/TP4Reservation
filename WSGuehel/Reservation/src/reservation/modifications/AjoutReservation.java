package reservation.modifications;

import java.sql.SQLException;

import reservation.objects.Reservation;

public class AjoutReservation extends ModificationReservation  {

	public AjoutReservation() throws ClassNotFoundException, SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean modifier(Reservation reservation) {
		boolean retour = false;
		if(valider(reservation))
		retour = this.daoReservation.create(reservation);
		return retour;
	}

	

}
