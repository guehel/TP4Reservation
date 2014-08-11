package services;

import java.util.Observable;

/**
 * Controleur d'authentification d'employ�s
 * 
 * @author Steve Boisvert
 * 
 */
public class ConnectionService extends Observable
{
	private static ConnectionService	instance;

	/**
	 * Constructeur priv� du service de Connection
	 */
	private ConnectionService()
	{
	}

	/**
	 * Accesseur de l'instance du service de connection.
	 * 
	 * @return le service de connection.
	 */
	public static ConnectionService getInstance()
	{
		if (instance == null)
		{
			instance = new ConnectionService();
		}

		return instance;
	}

	/**
	 * � utiliser lors d'une demande de connection.
	 * 
	 * @param employeId
	 *            l'id de l'employ� qui fait la demande de connection.
	 */
	public void connect(long employeId)
	{
		this.setChanged();
		this.notifyObservers(employeId);
	}
}