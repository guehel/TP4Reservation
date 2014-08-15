package reservation.entites;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import reservation.dao.OutilsDates;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;
import reservation.objects.Reservation;

public class EntiteReservation extends Entite {
	private Reservation reservation;

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public EntiteReservation(Reservation reservation) {
		super();
		this.reservation = reservation;
	}

	public EntiteReservation(ReservationDTO reservationDTO) throws Exception {
		super();
		this.setReservationFromDTO(reservationDTO);
	}

	public EntiteReservation() {
		super();

	}

	public void setReservationFromDTO(ReservationDTO reservationDto)
			throws Exception {

		DateTime dateCreation = OutilsDates.stringToJodaDate(reservationDto
				.getCreation());
		DateTime dateArrivee = OutilsDates.stringToJodaDate(reservationDto
				.getArrivee());
		DateTime dateDepart = OutilsDates.stringToJodaDate(reservationDto
				.getDepart());
		EntiteChambre entiteChambre = new EntiteChambre(
				reservationDto.getChambreDTO());

		this.reservation = new Reservation();
		this.reservation.setIdReservation(reservationDto.getIdReservation());
		this.reservation.setChambre(entiteChambre.getChambre());
		this.reservation.setClient(reservationDto.getClientDTO().getClient());
		this.reservation.setCreation(dateCreation);
		this.reservation.setInterval(new Interval(dateArrivee, dateDepart));
	}

	public ReservationDTO getReservationDTO() {
		ReservationDTO reservationDto = new ReservationDTO();
		int idReservation = reservation.getIdReservation();
		;
		String creation = OutilsDates.stringFromDateTime(reservation
				.getCreation());
		String arrivee = OutilsDates.stringFromDateTime(reservation
				.getInterval().getStart());
		String depart = OutilsDates.stringFromDateTime(reservation
				.getInterval().getEnd());
		EntiteClient entiteClient = new EntiteClient(reservation.getClient());
		ClientDTO clientDTO = entiteClient.getClientDTO();

		EntiteChambre entiteChambre = new EntiteChambre(
				reservation.getChambre());
		ChambreDTO chambreDTODB = entiteChambre.getChambreDTO();

		reservationDto.setIdReservation(idReservation);
		reservationDto.setCreation(creation);
		reservationDto.setArrivee(arrivee);
		reservationDto.setDepart(depart);
		reservationDto.setClientDTO(clientDTO);
		reservationDto.setChambreDTO(chambreDTODB);

		return reservationDto;
	}

}
