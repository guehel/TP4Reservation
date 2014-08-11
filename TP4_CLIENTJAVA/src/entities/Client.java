package entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Classe Client utilisé par la l'application Client.
 * 
 * @author Steve Boisvert.
 * 
 */
public class Client
{
	private String	nom;
	private long	id;

	/**
	 * Accesseur de l'id du Client.
	 * 
	 * @return l'id du Client.
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * Accesseur du nom du client.
	 * 
	 * @return le nom du client.
	 */
	public String getNom()
	{
		return nom;
	}

	/**
	 * Mutateur du nom du client.
	 * 
	 * @param nom
	 *            , le nom du client.
	 */
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
	 * Accesseur de la propriété du nom du Client.
	 * 
	 * @return la propriété du nom du Client.
	 */
	public StringProperty getNomProperty()
	{
		return new SimpleStringProperty(nom);
	}

	@Override
	public String toString()
	{
		return nom;
	}
}