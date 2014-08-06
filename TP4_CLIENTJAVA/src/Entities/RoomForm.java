package Entities;

import services.QuerableEntity;

public class RoomForm implements QuerableEntity
{
	private long id;
	private Reservation reservation;
	private int type;
	private int idUser;

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

	public Reservation getReservation()
	{
		return reservation;
	}

	public void setReservation(Reservation reservation)
	{
		this.reservation = reservation;
	}

	public int getType()
	{
		return type;
	}

	public void setType(int type)
	{
		this.type = type;
	}

	public int getIdUser()
	{
		return idUser;
	}

	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}
}
