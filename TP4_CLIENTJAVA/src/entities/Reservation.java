package entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Classe de la Réservation utilisée par l'application Client.
 * 
 * @author Steve Boisvert.
 * 
 */
public class Reservation
{
	private long		id;
	private Room		room;
	private Client		client;
	private Interval	reservationTime;
	private DateTime	creation;

	/**
	 * Accesseur de l'id de la réservation.
	 * 
	 * @return l'id de la Réservation.
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Mutateur de l'id de la réservation.
	 * 
	 * @param id
	 *            , l'id de la réservation.
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * Accesseur de la chambre liée à cette réservation.
	 * 
	 * @return la chambre liée à cette réservation.
	 */
	public Room getRoom()
	{
		return room;
	}

	/**
	 * Mutateur de la chambre liée à cette réservation.
	 * 
	 * @param room
	 *            , la chambre liée à cette réservation.
	 */
	public void setRoom(Room room)
	{
		this.room = room;
	}

	/**
	 * Accesseur du client lié à cette réservation.
	 * 
	 * @return le client lié à cette réservation.
	 */
	public Client getClient()
	{
		return client;
	}

	/**
	 * Mutateur du client lié à cette réservation.
	 * 
	 * @param client
	 *            , le client lié à cette réservation.
	 */
	public void setClient(Client client)
	{
		this.client = client;
	}

	/**
	 * Accesseur de l'interval de cette réservation.
	 * 
	 * @return l'interval de cette réservation.
	 */
	public Interval getReservationTime()
	{
		return reservationTime;
	}

	/**
	 * Mutateur de l'interval de cette réservation.
	 * 
	 * @param reservationTime
	 *            , l'interval de cette réservation.
	 */
	public void setReservationTime(Interval reservationTime)
	{
		this.reservationTime = reservationTime;
	}

	/**
	 * Accesseur de la date de la création de cette réservation.
	 * 
	 * @return La date de la création de cette réservation.
	 */
	public DateTime getCreation()
	{
		return creation;
	}

	/**
	 * Accesseur de la propriété de la date de la création de cette réservation.
	 * 
	 * @return La propriété de la date de la création de cette réservation.
	 */
	public StringProperty getReservationTimeProperty()
	{
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		String string = reservationTime.getStart().toString(fmt) + " - "
				+ reservationTime.getEnd().toString(fmt);
		return new SimpleStringProperty(string);
	}
}