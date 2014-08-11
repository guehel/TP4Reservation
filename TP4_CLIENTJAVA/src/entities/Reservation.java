package entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * Classe de la R�servation utilis�e par l'application Client.
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
	 * Accesseur de l'id de la r�servation.
	 * 
	 * @return l'id de la R�servation.
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Mutateur de l'id de la r�servation.
	 * 
	 * @param id
	 *            , l'id de la r�servation.
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * Accesseur de la chambre li�e � cette r�servation.
	 * 
	 * @return la chambre li�e � cette r�servation.
	 */
	public Room getRoom()
	{
		return room;
	}

	/**
	 * Mutateur de la chambre li�e � cette r�servation.
	 * 
	 * @param room
	 *            , la chambre li�e � cette r�servation.
	 */
	public void setRoom(Room room)
	{
		this.room = room;
	}

	/**
	 * Accesseur du client li� � cette r�servation.
	 * 
	 * @return le client li� � cette r�servation.
	 */
	public Client getClient()
	{
		return client;
	}

	/**
	 * Mutateur du client li� � cette r�servation.
	 * 
	 * @param client
	 *            , le client li� � cette r�servation.
	 */
	public void setClient(Client client)
	{
		this.client = client;
	}

	/**
	 * Accesseur de l'interval de cette r�servation.
	 * 
	 * @return l'interval de cette r�servation.
	 */
	public Interval getReservationTime()
	{
		return reservationTime;
	}

	/**
	 * Mutateur de l'interval de cette r�servation.
	 * 
	 * @param reservationTime
	 *            , l'interval de cette r�servation.
	 */
	public void setReservationTime(Interval reservationTime)
	{
		this.reservationTime = reservationTime;
	}

	/**
	 * Accesseur de la date de la cr�ation de cette r�servation.
	 * 
	 * @return La date de la cr�ation de cette r�servation.
	 */
	public DateTime getCreation()
	{
		return creation;
	}

	/**
	 * Accesseur de la propri�t� de la date de la cr�ation de cette r�servation.
	 * 
	 * @return La propri�t� de la date de la cr�ation de cette r�servation.
	 */
	public StringProperty getReservationTimeProperty()
	{
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		String string = reservationTime.getStart().toString(fmt) + " - "
				+ reservationTime.getEnd().toString(fmt);
		return new SimpleStringProperty(string);
	}
}