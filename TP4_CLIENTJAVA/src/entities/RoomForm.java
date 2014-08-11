package entities;

/**
 * Un Formulaire d'ajout ou annulation d'une r�servation.
 * 
 * @author Steve Boisvert
 * 
 */
public class RoomForm
{
	private Reservation	reservation;
	private int			type;
	private int			idUser;

	/**
	 * Accesseur de la r�servation li�e au formulaire.
	 * 
	 * @return la r�servation.
	 */
	public Reservation getReservation()
	{
		return reservation;
	}

	/**
	 * Mutateur de la r�servation li�e au formulaire.
	 * 
	 * @param reservation
	 *            , la r�servation.
	 */
	public void setReservation(Reservation reservation)
	{
		this.reservation = reservation;
	}

	/**
	 * Accesseur du type du formulaire.
	 * 
	 * @return le type du formulaire.
	 */
	public int getType()
	{
		return type;
	}

	/**
	 * Mutateur du type du formulaire.
	 * 
	 * @param type
	 *            , le type du formulaire.
	 */
	public void setType(int type)
	{
		this.type = type;
	}

	/**
	 * Accesseur de l'identifiant de l'utilisateur remplissant le formulaire.
	 * 
	 * @return l'utilisateur remplissant le formulaire.
	 */
	public int getIdUser()
	{
		return idUser;
	}

	/**
	 * Mutateur de l'identifiant de l'utilisateur remplissant le formulaire.
	 * 
	 * @param idUser
	 *            , l'utilisateur remplissant le formulaire.
	 */
	public void setIdUser(int idUser)
	{
		this.idUser = idUser;
	}
}
