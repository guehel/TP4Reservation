package entities;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;
import services.ClientService;

/**
 * Factory servant de convertion entre les objets reçu par le serveur et ceux
 * utilisés par l'application et vice-verca.
 * 
 * @author Steve Boisvert.
 * 
 */
public class EntityFactory
{
	/**
	 * Converti un chambreDTO en Room.
	 * 
	 * @param chambreDTO
	 *            , la chambre à convertir.
	 * @return l'équivalent en Room.
	 */
	public Room convertChambreDTO(ChambreDTO chambreDTO)
	{
		Room newRoom = new Room();
		newRoom.setId(chambreDTO.getNumeroChambre());
		for (ReservationDTO reservationDTO : chambreDTO.getReservations())
		{
			Reservation reservation = convertReservationDTO(reservationDTO);
			reservation.setRoom(newRoom);
			newRoom.addReservations(reservation);
		}
		return newRoom;
	}

	/**
	 * Converti une reservationDTO en Reservation.
	 * 
	 * @param reservationDTO
	 *            , la reservationDTO à convertir.
	 * @return, la Reservation.
	 */
	private Reservation convertReservationDTO(ReservationDTO reservationDTO)
	{
		Reservation reservation = new Reservation();
		reservation.setId(reservationDTO.getIdReservation());
		reservation.setClient(convertClientDTO(reservationDTO.getClientDTO()));
		DateTime arrive = new DateTime(reservationDTO.getArrivee());
		DateTime depart = new DateTime(reservationDTO.getDepart());
		reservation.setReservationTime(new Interval(arrive, depart));

		return reservation;
	}

	/**
	 * Converti un clientDTO en Client.
	 * 
	 * @param clientDTO
	 *            , le clientDTO à convertir.
	 * @return le client.
	 */
	public Client convertClientDTO(ClientDTO clientDTO)
	{
		Client client = new Client();
		client.setNom(clientDTO.getPrenom() + " " + clientDTO.getNom());
		return client;
	}

	/**
	 * Converti un RoomForm en Formulaire.
	 * 
	 * @param formulaire
	 *            , le RoomForm à convertir.
	 * @return le formulaire.
	 */
	public Formulaire convertRoomForm(RoomForm formulaire)
	{
		Formulaire newForm = new Formulaire();
		newForm.setIdUser(formulaire.getIdUser());
		newForm.setReservation(convertReservation(formulaire.getReservation()));
		return null;
	}

	/**
	 * Converti une réservation en reservationDTO.
	 * 
	 * @param reservation
	 *            , la reservation à convertir.
	 * @return la réservationDTO.
	 */
	private ReservationDTO convertReservation(Reservation reservation)
	{
		ReservationDTO reservationDTO = new ReservationDTO();
		DateTimeFormatter dateFormatter = DateTimeFormat
				.forPattern("yyyy-MM-dd");
		reservationDTO.setArrivee(reservation.getReservationTime().getStart()
				.toString(dateFormatter));
		reservationDTO.setDepart(reservation.getReservationTime().getEnd()
				.toString(dateFormatter));
		reservationDTO.setClientDTO(getClientDTO(reservation.getClient()));

		return reservationDTO;
	}

	/**
	 * Converti un client en clientDTO
	 * 
	 * @param client
	 *            , le client à convertir.
	 * @return, le clientDTO.
	 */
	private ClientDTO getClientDTO(Client client)
	{
		return ClientService.getInstance().getDTO(client.getId());
	}
}
