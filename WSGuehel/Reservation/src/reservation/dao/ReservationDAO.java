package reservation.dao;

import com.mysql.jdbc.Connection;








import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TreeSet;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import com.mysql.jdbc.PreparedStatement;
//import com.mysql.jdbc.ResultSet;








import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.ComparateurReservation;
import reservation.objects.Reservation;

public class ReservationDAO extends DAO<Reservation>{
	
	private ClientDAO daoClient;
	private ChambreDAO daoChambre;
	

	public ReservationDAO(Connection connection) {
		super(connection);
		
		try {
			this.ajout = (PreparedStatement) connection.prepareStatement(
					"INSERT INTO `reservation`"
					+ "( `arrivee`, `sejour`, `numero`, `dateCreation`, `id`) "
					+ "VALUES (?,?,?,?,?)"
					);
			this.miseAJour =  (PreparedStatement) connection.prepareStatement(
					"UPDATE `reservation` "
					+ "SET `idReservation`=? ,`arrivee`=?,`sejour`=?,`numero`=?"
					+ ",`dateCreation`=?,`id`=? WHERE `idReservation`=?"
					);
			this.rechercher =  (PreparedStatement) connection.prepareStatement(
					"SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
					+ "FROM `reservation` "
					+ "WHERE `idReservation` =?  AND `numero` =?"
					);
			
			this.rechercherTous =  (PreparedStatement) connection.prepareStatement(
					"SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
					+ "FROM `reservation` "
				
					);
			this.suppression =  (PreparedStatement) connection.prepareStatement(
					"DELETE FROM `reservation` "
					+ "WHERE `idReservation` =?  AND `numero` =?"
					);
			//daoClient = new ClientDAO(connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Reservation reservation) {
		boolean reussite= false;
		ReservationDTO reservationDTO  = new ReservationDTO(reservation);
		this.saveFromDTO(reservationDTO);
		//TODO : gerer les erreur
		reussite= true;
		return reussite;
	}

	@Override
	public boolean delete(Reservation object) {
	try {
		
			this.suppression.setInt(1,object.getIdReservation());
			this.suppression.setInt(2,object.getClient().getIdClient());
			
		
			
			int resultat = this.suppression.executeUpdate();
			return resultat == 1;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Reservation find(Reservation object) {
		
		return findByIds(object.getIdReservation(),  object.getChambre().getNumeroChambre());
	}

	public Reservation findByIds(int idReservation, int numeroChambre) {
		Reservation reservation = null;
		try {	
			this.rechercher.setInt(1, idReservation);
			this.rechercher.setInt(2, numeroChambre);
			 ResultSet resultat = this.rechercher.executeQuery();
			if(resultat.next()){
				
				reservation = resultSetToReservation(resultat);


			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return reservation;
	}

	public TreeSet<Reservation> getAllReservations() {
		TreeSet<Reservation> toutesReservation = 
				new TreeSet<Reservation>(new ComparateurReservation());
		Reservation reservation = null;
		try {
		
			 ResultSet resultat = this.rechercherTous.executeQuery();
			while(resultat.next()){
				
				reservation = resultSetToReservation(resultat);
				toutesReservation.add(reservation);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return toutesReservation;
	}

	private Reservation resultSetToReservation(java.sql.ResultSet resultat) {
		Reservation reservation = null;
		try {
			daoClient = new ClientDAO(connection);
			daoChambre = new ChambreDAO(connection);
			Client client =daoClient.findById( resultat.getInt(6));
			Chambre chambre = daoChambre.findByNumeroChambre(resultat.getInt(4));
			DateTime creation = new DateTime(resultat.getDate(5));
			DateTime arrivee = new DateTime(resultat.getDate(2));
			DateTime depart = arrivee.plusDays(resultat.getInt(3));
			Interval interval = new Interval(arrivee, depart);
			
			reservation = new Reservation();
			reservation.setIdReservation(resultat.getInt(1));
			
			reservation.setClient(client);
			
			reservation.setChambre(chambre);
			
			reservation.setCreation(creation);
			
			reservation.setInterval(interval);
			


		

	} catch (SQLException e) {

		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return reservation;
	}


	public void saveFromDTO(ReservationDTO reservationDTO) {
		try {
//			this.ajout.setInt(1, reservationDTO.getIdReservation());
			Date arriveeSQL = OutilsDates.stringToSqlDate(reservationDTO.getArrivee());
			DateTime arriveDateTime = OutilsDates.stringToJodaDate(reservationDTO.getArrivee());
			DateTime depart = OutilsDates.stringToJodaDate(reservationDTO.getDepart());
			this.ajout.setDate(2 - 1, arriveeSQL);
			int duree = Days.daysBetween(
					arriveDateTime, 
					depart)
					.getDays();
			
			this.ajout.setInt(3 - 1, duree);
			this.ajout.setInt(4- 1, reservationDTO.getChambreDTO().getNumeroChambre());
			Date dateCreation = OutilsDates.stringToSqlDate(reservationDTO.getCreation());
			this.ajout.setDate(5- 1, dateCreation);
			this.ajout.setInt(6 - 1, reservationDTO.getClientDTO().getId());
			int resultat = this.ajout.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

	@Override
	public boolean update(Reservation object) {
		// TODO Auto-generated method stub
		return false;
	}

}
