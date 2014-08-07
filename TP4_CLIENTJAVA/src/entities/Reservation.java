package entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Reservation
{
	private long id;
	private Room room;
	private Client client;
	private Interval reservationTime;
	private DateTime creation;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public Room getRoom()
	{
		return room;
	}

	public void setRoom(Room room)
	{
		this.room = room;
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(Client client)
	{
		this.client = client;
	}

	public Interval getReservationTime()
	{
		return reservationTime;
	}

	public void setReservationTime(Interval reservationTime)
	{
		this.reservationTime = reservationTime;
	}

	public DateTime getCreation()
	{
		return creation;
	}
	
	public StringProperty getReservationTimeProperty()
	{
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-MM-dd");
		String string = reservationTime.getStart().toString(fmt) + " - " + reservationTime.getEnd().toString(fmt);
		return new SimpleStringProperty(string);
	}
	
}
