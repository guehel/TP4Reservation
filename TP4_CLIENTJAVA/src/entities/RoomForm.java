package entities;


public class RoomForm
{
	private long id;
	private Reservation reservation;
	private int type;
	private int idUser;

	public long getId()
	{
		return id;
	}

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
