package services;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import entities.Client;
import entities.Reservation;
import entities.Room;
import entities.RoomForm;

public class RoomService

{
	private static RoomService instance;

	private RoomService()
	{
	}

	public static RoomService getInstance()
	{
		if (instance == null)
		{
			instance = new RoomService();
		}

		return instance;
	}

	public List<Room> query()
	{
		List<Room> list = new ArrayList<Room>();
		Room room1 = new Room();
		room1.setId(1);
		list.add(room1);

		Client client = new Client();
		client.setNom("Steve");

		Reservation reservation = new Reservation();
		reservation.setClient(client);
		DateTime start = new DateTime(2004, 12, 25, 0, 0, 0, 0);
		DateTime end = new DateTime(2005, 1, 1, 0, 0, 0, 0);
		Interval interval = new Interval(start, end);
		reservation.setReservationTime(interval);

		room1.addReservations(reservation);
		
		RoomForm form = new RoomForm();
		room1.setFormulaire(form);

		Room room2 = new Room();
		room2.setId(2);
		list.add(room2);

		Room room3 = new Room();
		room3.setId(3);
		list.add(room3);

		Room room4 = new Room();
		room4.setId(4);
		list.add(room4);

		return list;
	}

	public Room get(long id)
	{
		return null;
	}
	
	public void update(Room room)
	{
		
	}
}
