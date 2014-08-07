package entities;

import java.util.ArrayList;
import java.util.List;

public class Room
{
	private long id;
	private List<Reservation> reservations;
	private RoomForm formulaire;

	public Room()
	{
		reservations = new ArrayList<Reservation>();
	}

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

	public List<Reservation> getReservations()
	{
		return reservations;
	}

	public void addReservations(Reservation reservation)
	{
		this.reservations.add(reservation);
	}

	public RoomForm getFormulaire()
	{
		return formulaire;
	}

	public void setFormulaire(RoomForm formulaire)
	{
		this.formulaire = formulaire;
	}
}
