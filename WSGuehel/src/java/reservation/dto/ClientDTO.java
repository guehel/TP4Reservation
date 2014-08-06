/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation.dto;

import java.util.HashSet;
import java.util.Set;
import reservation.ReservationHelper;
import reservation.donnes.*;


/**
 *
 * @author boug18087415
 */
public class ClientDTO {

    private Integer id;
    private String nom;
    private String prenom;
    private ReservationDTO[] reservations;

    public ClientDTO(Client client) {
        id = client.getId();
        nom = client.getNom();
        prenom = client.getPrenom();
        reservations = (ReservationDTO[])client.getReservations().toArray();
    }

    public Integer getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
    public static void main(String [] args){ 
       /* ReservationHelper resa = new ReservationHelper();
        ChambreDTO chambre = resa.getAvailableRoom().get(0);
        Set set = chambre.getReservations();
        for(Object o: set){
            Reservation res= (Reservation)o;
            System.out.print("Reservation"+res.getChambre());
        }*/
    }
}
