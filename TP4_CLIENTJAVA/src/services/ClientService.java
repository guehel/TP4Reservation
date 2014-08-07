package services;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import entities.Client;
import entities.Reservation;
import entities.Room;
import entities.RoomForm;

public class ClientService

{
	private static ClientService instance;

	private ClientService()
	{
	}

	public static ClientService getInstance()
	{
		if (instance == null)
		{
			instance = new ClientService();
		}

		return instance;
	}

	public List<Client> query()
	{
		List<Client> list = new ArrayList<Client>();
		Client client1 = new Client();
		client1.setNom("Paul Raspoutine");
		list.add(client1);

		Client client2 = new Client();
		client2.setNom("Steve");
		list.add(client2);

		return list;
	}

	public Client get(long id)
	{
		return null;
	}
	
	public void update(Room room)
	{
		
	}
}
