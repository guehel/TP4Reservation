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

public class GrandLivreHotel extends Entite implements GrandLivre {
	
	private ReservationDAO reservationDAO;

	public GrandLivreHotel(){
		try {
			reservationDAO = (ReservationDAO) (new DAOFactory()).getDAO(Table.RESERVATION);
			this.reservations = reservationDAO.getAllReservations();
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
	public TreeSet<Reservation> getReservations(Client client) {
		TreeSet<Reservation> reservationsClient = new TreeSet<Reservation>(
				new ComparateurReservation());
		for(Reservation reservation: reservations){
			if(reservation.getClient().equals(client)){
				reservationsClient.add(reservation);
			}
		}
		return reservationsClient;
	}
	@Override
	public TreeSet<Reservation> obtenirReservations(Chambre chambre) {
		DateTime now = new DateTime();
		
		TreeSet<Reservation> reservationsChambre = new TreeSet<Reservation>(
				new ComparateurReservation());
		for(Reservation reservation: reservations){
			if(reservation.getChambre().equals(chambre)
					
					){
				reservationsChambre.add(reservation);
			}
		}
		return reservationsChambre;
	}

	



}
