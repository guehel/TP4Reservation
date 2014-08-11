package entities;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;

/**
 * Factory servant de convertion entre les objets reçu par le serveur et ceux
 * utilisés par l'application et vice-verca.
 * 
 * @author Steve Boisvert.
 * 
 */
public class EntityAdapter
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
		if (chambreDTO.getReservations() != null)
		{
			for (ReservationDTO reservationDTO : chambreDTO.getReservations())
			{
				Reservation reservation = convertReservationDTO(reservationDTO);
				newRoom.addReservations(reservation);

				// Sauvegarde une genre de copie de la chambre

				ChambreDTO refChambreDTO = new ChambreDTO();
				refChambreDTO
						.setNumeroChambre(refChambreDTO.getNumeroChambre());
				reservationDTO.setChambreDTO(refChambreDTO);
			}
		}
		newRoom.setFormulaire(convertFormulaireDTO(chambreDTO.getFormulaire()));
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
		client.setId(clientDTO.getId());
		client.setNom(clientDTO.getPrenom() + " " + clientDTO.getNom());
		return client;
	}

	/**
	 * Converti un formulaire en formulaireDTO.
	 * 
	 * @param formulaire
	 *            , le formulaire à convertir.
	 * @return le formulaireDTO.
	 */
	private RoomForm convertFormulaireDTO(Formulaire formulaire)
	{
		RoomForm roomForm = new RoomForm();
		return roomForm;
	}

	/**
	 * Converti une chambre en chambreDTO
	 * 
	 * @param room
	 *            la chambre à convertir.
	 * @return la chambreDTO
	 */
	public ChambreDTO convertRoom(Room room)
	{
		ChambreDTO chambreDTO = new ChambreDTO();
		chambreDTO.setNumeroChambre((int) room.getId());
		chambreDTO.setFormulaire(convertFormulaireDTO(room.getFormulaire()));

		// Copie de la chambre en référence dans la réservation.
		ChambreDTO refChambreDTO = new ChambreDTO();
		refChambreDTO.setNumeroChambre(chambreDTO.getNumeroChambre());
		chambreDTO.getFormulaire().getReservation()
				.setChambreDTO(refChambreDTO);
		return chambreDTO;
	}

	/**
	 * Converti un RoomForm en Formulaire.
	 * 
	 * @param formulaire
	 *            le RoomForm à convertir.
	 * @return le formulaire converti.
	 */
	private Formulaire convertFormulaireDTO(RoomForm formulaire)
	{
		Formulaire newFormulaire = new Formulaire();
		newFormulaire.setIdUser(formulaire.getIdUser());
		newFormulaire.setType(formulaire.getType());
		newFormulaire.setReservation(convertReservationDTO(formulaire
				.getReservation()));
		return newFormulaire;
	}

	/**
	 * Converti une réservation en reservationDTO.
	 * 
	 * @param reservation
	 *            , la reservation à convertir.
	 * @return la réservationDTO.
	 */
	private ReservationDTO convertReservationDTO(Reservation reservation)
	{
		ReservationDTO reservationDTO = new ReservationDTO();
		reservationDTO.setIdReservation((int) reservation.getId());
		DateTimeFormatter dateFormatter = DateTimeFormat
				.forPattern("yyyy-MM-dd");
		reservationDTO.setArrivee(reservation.getReservationTime().getStart()
				.toString(dateFormatter));
		reservationDTO.setDepart(reservation.getReservationTime().getEnd()
				.toString(dateFormatter));
		reservationDTO.setClientDTO(convertClientDTO(reservation.getClient()));

		return reservationDTO;
	}

	/**
	 * Converti un client en clientDTO
	 * 
	 * @param client
	 *            , le client à convertir.
	 * @return, le clientDTO.
	 */
	private ClientDTO convertClientDTO(Client client)
	{
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setId((int) client.getId());
		return clientDTO;
	}
}