package reservation.objects;

import reservation.entites.Entite;



public class Client extends Entite  {
	private int idClient;

    private String nom;

    private String prenom;

  

	public int getIdClient() {
		
		return idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0!=null){
		Client client = (Client) arg0;
		return idClient == client.getIdClient();
		}else return false;
	}
	
	

}
