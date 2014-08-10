package reservation.modifications;

import java.sql.SQLException;

import reservation.GrandLivreHotel;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;
import reservation.dto.ReservationDTO;
import reservation.objects.Reservation;

public abstract class ModificationReservation implements Modification {
	protected ReservationDAO daoReservation ;
	protected GrandLivreHotel grandLivre; 
	
	public ModificationReservation(GrandLivreHotel grandLivre) throws ClassNotFoundException, SQLException{
		daoReservation = (ReservationDAO) new DAOFactory().getDAO(Table.RESERVATION);
		this.grandLivre = grandLivre;
	}
	
	protected boolean valider(Reservation reservation) {
	
		return reservation!=null && reservation.isValide();
	}
	
	

}
