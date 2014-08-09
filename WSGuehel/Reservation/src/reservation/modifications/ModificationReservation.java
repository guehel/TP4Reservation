package reservation.modifications;

import java.sql.SQLException;

import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;
import reservation.objects.Reservation;

public abstract class ModificationReservation implements Modification {
	protected ReservationDAO daoReservation ; 
	public ModificationReservation() throws ClassNotFoundException, SQLException{
		daoReservation = (ReservationDAO) new DAOFactory().getDAO(Table.RESERVATION);
	}
	
	protected boolean valider(Reservation reservation) {
	
		return reservation!=null && reservation.isValide();
	}

	

}
