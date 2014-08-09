package reservation;

import java.sql.SQLException;
import java.util.TreeSet;

import org.joda.time.DateTime;

import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.ComparateurReservation;
import reservation.objects.Entite;
import reservation.objects.Reservation;
import reservation.recherches.RechercheFactory;
import reservation.recherches.RechercheReservation;

public class GrandLivreHotel extends Entite implements GrandLivre {
	
	private ReservationDAO reservationDAO;
	private RechercheFactory recherchesfactory;

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
	
	



}
