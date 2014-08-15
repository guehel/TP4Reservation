package reservation.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;

import reservation.arbre.ArbreBinaireReservations;
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
	private PreparedStatement rechercherDate;
	private PreparedStatement rechercherClient;
	private PreparedStatement rechercherChambre;

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
			this.rechercherDate = connection
					.prepareStatement("SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
							+ "FROM `reservation` "
							+ "WHERE `arrivee` =?  AND `numero` =?");

			this.rechercherTous = connection
					.prepareStatement("SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
							+ "FROM `reservation` "

					);
			this.rechercherClient= connection
					.prepareStatement("SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` "
							+ "FROM `reservation` "
							+ "WHERE `id` =?  ");
			this.rechercherChambre = connection
					.prepareStatement("SELECT `idReservation`, `arrivee`, `sejour`, `numero`, `dateCreation`, `id` FROM `reservation` WHERE `numero` = ? LIMIT 0, 30");
			

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
		ReservationDTO dto = new EntiteReservation(reservation)
				.getReservationDTO();
		if (dto.getIdReservation() <= 0) {
			reservation = findByDateAndRoom(dto.getArrivee(), dto
					.getChambreDTO().getNumeroChambre());
		} else {
			reservation = findByIds(reservation.getIdReservation(), reservation
					.getChambre().getNumeroChambre());
		}
		return reservation;
	}

	private Reservation findByDateAndRoom(String arrive, int numero) {

		Reservation reservation = null;
		try {
			this.rechercher.setString(1, arrive);
			this.rechercher.setInt(2, numero);
			ResultSet resultat = this.rechercher.executeQuery();
			if (resultat.next()) {

				reservation = resultSetToReservation(resultat);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return reservation;
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
		PreparedStatement recherche = this.rechercherTous;
		ArbreBinaireReservations toutesReservation = this.getfromStatement(recherche );
	
		return toutesReservation;
	}
	
	public ArbreBinaireReservations getRoomReservations(int numeroChambre) {
		PreparedStatement recherche = this.rechercherChambre;
		ArbreBinaireReservations toutesReservation = null;
		try {
			recherche.setInt(1, numeroChambre);
			toutesReservation = this.getfromStatement(recherche );
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	
		return toutesReservation;
	}
	
	public ArbreBinaireReservations getClientReservations(int idClient) {
		PreparedStatement recherche = this.rechercherClient;
		ArbreBinaireReservations toutesReservation = null;
		try {
			recherche.setInt(1, idClient);
			toutesReservation = this.getfromStatement(recherche );
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return toutesReservation;
	}
	
	private ArbreBinaireReservations getfromStatement(PreparedStatement recherche){
		ArbreBinaireReservations toutesReservation = new ArbreBinaireReservations();
		Reservation reservation = null;
		try {

			ResultSet resultat = recherche.executeQuery();
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
			this.ajout.executeUpdate();

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
