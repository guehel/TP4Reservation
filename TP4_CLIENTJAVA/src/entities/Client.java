package entities;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client
{
	private String nom;

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public StringProperty getNomProperty()
	{
		return new SimpleStringProperty(nom);

	}
	
	 @Override
     public String toString() {
         return nom;
     }

}
