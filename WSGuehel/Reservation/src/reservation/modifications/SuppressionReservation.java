package reservation.modifications;

import java.sql.SQLException;

import reservation.objects.Reservation;

public class SuppressionReservation extends ModificationReservation {
	
	public SuppressionReservation() throws ClassNotFoundException, SQLException {
		super();
	}

	@Override
	public boolean modifier(Reservation reservation) {
		boolean retour = false;
		if(valider(reservation))
		retour = this.daoReservation.delete(reservation);
		return retour;
	}
	
	@Override
	protected boolean valider(Reservation reservation) {
		if(!super.valider(reservation)) return false;
		else{
		Reservation resaEnregistree = this.daoReservation.find(reservation);
		return reservation.getClient().equals(resaEnregistree.getClient());
		}
		
	}

}
