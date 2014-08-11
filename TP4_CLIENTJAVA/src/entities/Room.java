package entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de la chambre utilisée par l'application client.
 * 
 * @author Steve Boisvert.
 * 
 */
public class Room
{
	private long					id;
	private final List<Reservation>	reservations;
	private RoomForm				formulaire;

	/**
	 * Constructeur de la Chambre.
	 */
	public Room()
	{
		reservations = new ArrayList<Reservation>();
	}

	/**
	 * Accesseur de l'id de la chambre.
	 * 
	 * @return l'id de la chambre.
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Mutateur de l'id de la chambre.
	 * 
	 * @param id
	 *            , l'id de la chambre.
	 */
	public void setId(long id)
	{
		this.id = id;
	}

	/**
	 * Accesseur de la liste des réservation liées à cette chambre.
	 * 
	 * @return La liste des réservation liées à cette chambre.
	 */
	public List<Reservation> getReservations()
	{
		return reservations;
	}

	/**
	 * Ajout d'une réservation à la chambre.
	 * 
	 * @param reservation
	 *            , la réservation à ajouter.
	 */
	public void addReservations(Reservation reservation)
	{
		this.reservations.add(reservation);
	}

	/**
	 * Accesseur du formulaire de la chambre.
	 * 
	 * @return le formulaire de la chambre.
	 */
	public RoomForm getFormulaire()
	{
		return formulaire;
	}

	/**
	 * Mutateur du formulaire de la chambre.
	 * 
	 * @param formulaire
	 *            , le formulaire de la chambre.
	 */
	public void setFormulaire(RoomForm formulaire)
	{
		this.formulaire = formulaire;
	}
}