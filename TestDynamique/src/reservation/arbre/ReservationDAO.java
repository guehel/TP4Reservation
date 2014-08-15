package reservation.arbre;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAO;
import reservation.dao.OutilsDates;
import reservation.dto.ReservationDTO;
import reservation.entites.EntiteReservation;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;

import com.mysql.jdbc.Connection;

//import com.mysql.jdbc.ResultSet;

public class ReservationDAO extends DAO<Reservation> {

	private ClientDAO daoClient;
	private ChambreDAO daoChambre;

	public ReservationDAO(Connection connection) {
		super(connection);

		try {
			this.ajout = connection
					.prepareStatement("INSERT INTO `reservation`"
							+ "( `arrivee`, `sejour`, `numero`, `dateCreation`, `id`) "
							+ "VALUES (?,?,?,?,?)");
			this.miseAJour = connection
					.prepareStatement("UPDATE `reservation` "
							+ "SET `idReservation`=? ,`arrivee`=?,`sejour`=?,`numero`=?"
							+ ",`dateCreation`=?,`id`=? WHERE `idReservation`=?");
			this.rechercher = connection
					.prepareStatement("SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
							+ "FROM `reservation` "
							+ "WHERE `idReservation` =?  AND `numero` =?");

			this.rechercherTous = connection
					.prepareStatement("SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
							+ "FROM `reservation` "

					);
			this.suppression = connection
					.prepareStatement("DELETE FROM `reservation` WHERE `idReservation` =? AND `numero` =?");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Reservation reservation) {
		boolean reussite = false;
		ReservationDTO reservationDTO = new EntiteReservation(reservation)
				.getReservationDTO();
		this.saveFromDTO(reservationDTO);
		reussite = true;
		return reussite;
	}

	@Override
	public boolean delete(Reservation reservation) {
		try {
			int idReservation = reservation.getIdReservation();
			int numeroChambre = reservation.getChambre().getNumeroChambre();
			this.suppression.setInt(1, idReservation);
			this.suppression.setInt(2, numeroChambre);

			int resultat = this.suppression.executeUpdate();
			return resultat == 1;

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Reservation find(Reservation reservation) {

		return findByIds(reservation.getIdReservation(), reservation
				.getChambre().getNumeroChambre());
	}

	public Reservation findByIds(int idReservation, int numeroChambre) {
		Reservation reservation = null;
		try {
			this.rechercher.setInt(1, idReservation);
			this.rechercher.setInt(2, numeroChambre);
			ResultSet resultat = this.rechercher.executeQuery();
			if (resultat.next()) {

				reservation = resultSetToReservation(resultat);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return reservation;
	}

	public ArbreBinaireReservations getAllReservations() {
		ArbreBinaireReservations toutesReservation = new ArbreBinaireReservations();
		Reservation reservation = null;
		try {

			ResultSet resultat = this.rechercherTous.executeQuery();
			while (resultat.next()) {

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
			Client client = daoClient.findById(resultat.getInt(6));
			Chambre chambre = daoChambre
					.findByNumeroChambre(resultat.getInt(4));
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

			Date arriveeSQL = OutilsDates.stringToSqlDate(reservationDTO
					.getArrivee());
			DateTime arriveDateTime = OutilsDates
					.stringToJodaDate(reservationDTO.getArrivee());
			DateTime depart = OutilsDates.stringToJodaDate(reservationDTO
					.getDepart());
			this.ajout.setDate(2 - 1, arriveeSQL);
			int duree = Days.daysBetween(arriveDateTime, depart).getDays();

			this.ajout.setInt(3 - 1, duree);
			this.ajout.setInt(4 - 1, reservationDTO.getChambreDTO()
					.getNumeroChambre());
			Date dateCreation = OutilsDates.stringToSqlDate(reservationDTO
					.getCreation());
			this.ajout.setDate(5 - 1, dateCreation);
			this.ajout.setInt(6 - 1, reservationDTO.getClientDTO().getId());
			/* int resultat = */this.ajout.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

	}

	@Override
	public boolean update(Reservation reservation) {
		// TODO Auto-generated method stub
		return false;
	}

}
