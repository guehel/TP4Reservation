package entities;

import java.util.List;

import services.entityService.ServiceableEntityInterface;

public class Room implements ServiceableEntityInterface
{
	private long id;
	private List<Reservation> reservations;
	private RoomForm formulaire;

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
	
	public List<Reservation> getReservations()
	{
		return reservations;
	}

	public void setReservations(List<Reservation> reservations)
	{
		this.reservations = reservations;
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
