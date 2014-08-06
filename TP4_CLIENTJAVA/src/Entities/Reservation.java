package Entities;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import services.QuerableEntity;

public class Reservation implements QuerableEntity
{
	private long id;
	private Room room;
	private Client client;
	private Interval reservationTime;
	private DateTime creation;

	@Override
	public long getId()
	{
		return id;
	}

	@Override
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
	
}
