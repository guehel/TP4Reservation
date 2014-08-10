package reservation;

import java.sql.SQLException;
import java.util.TreeSet;

import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;
import reservation.modifications.Modification;
import reservation.modifications.modificationFactory;
import reservation.objects.Entite;
import reservation.objects.Reservation;
import reservation.recherches.RechercheFactory;
import reservation.recherches.RechercheReservation;

public class GrandLivreHotel extends Entite implements GrandLivre {
	
	private ReservationDAO reservationDAO;
	private RechercheFactory recherchesfactory;
	private Modification modification;

	public GrandLivreHotel(){
		try {
			reservationDAO = (ReservationDAO) (new DAOFactory()).getDAO(Table.RESERVATION);
			reservations = reservationDAO.getAllReservations();
			recherchesfactory = new RechercheFactory(reservations);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public boolean reserver(Reservation reservation) {
		reservationDAO.create(reservation);
		return  this.reservations.add(reservation);
		
	}
	
	@Override
	public TreeSet<Reservation> getReservations(Entite client) {
		TreeSet<Reservation> reservationsClient = null;
		RechercheReservation recherche = recherchesfactory.getRechercheReservation(client);
		reservationsClient = recherche.rechercher();
		return reservationsClient;
	}
	
	@Override
	public boolean modifierChambre(Reservation reservation, int type) {
		
		this.modification = modificationFactory.getModifications(type);
		boolean modifie = this.modification.modifier(reservation);
		if(modifie)reservations = reservationDAO.getAllReservations();
		return modifie;
	}
	
	



}
