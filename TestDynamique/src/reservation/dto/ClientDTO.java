/**
 * ClientDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package reservation.dto;


import reservation.objects.Client;


public class ClientDTO extends EntiteDTO {
    private int id;

    private java.lang.String nom;

    private java.lang.String prenom;

  

    public ClientDTO() {
    }

    public ClientDTO(
           int id,
           java.lang.String nom,
           java.lang.String prenom,
           reservation.dto.ReservationDTO[] reservations) {
           this.id = id;
           this.nom = nom;
           this.prenom = prenom;
           this.reservations = reservations;
    }


    public ClientDTO(Client client) {
    	 this.id = client.getIdClient();
         this.nom = client.getNom();
         this.prenom = client.getPrenom();
       
	}


	/**
     * Gets the id value for this ClientDTO.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this ClientDTO.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the nom value for this ClientDTO.
     * 
     * @return nom
     */
    public java.lang.String getNom() {
        return nom;
    }


    /**
     * Sets the nom value for this ClientDTO.
     * 
     * @param nom
     */
    public void setNom(java.lang.String nom) {
        this.nom = nom;
    }


    /**
     * Gets the prenom value for this ClientDTO.
     * 
     * @return prenom
     */
    public java.lang.String getPrenom() {
        return prenom;
    }


    /**
     * Sets the prenom value for this ClientDTO.
     * 
     * @param prenom
     */
    public void setPrenom(java.lang.String prenom) {
        this.prenom = prenom;
    }

	public  Client getClient() {
		Client client = new Client();
		client.setIdClient(this.id);
		client.setNom(this.nom);
		client.setPrenom(this.prenom);
		return client;
	}

	


   


}
