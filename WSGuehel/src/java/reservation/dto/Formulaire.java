/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reservation.dto;

/**
 *Formulaire charger de receuiller les reservation et les annulations
 * @author boug18087415
 */
public class Formulaire {
    private String dateModification="";
    private int idUser=0;
    private ReservationDTO reservation  = new ReservationDTO();
    
    /*  1=consultation
        0 = annulation
    */
    private int type;

    public String getDateModification() {
        return dateModification;
    }

    public int getIdUser() {
        return idUser;
    }

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setReservation(ReservationDTO reservation) {
        this.reservation = reservation;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    
}
