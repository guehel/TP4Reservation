package reservation.dto;

import reservation.objects.Client;
import reservation.objects.Reservation;

/*
**
*Formulaire charger de receuiller les reservation et les annulations
* @author boug18087415
*/
public class Formulaire {
    private String dateModification="";
    private int userQuiAchange=0;
    private ReservationDTO reservation = new ReservationDTO();
    private int type;
    
    /* 1=consultation
	0 = annulation
     */
    
    public  Formulaire(){
    
    }
    
    
   

    public String getDateModification() {
        return dateModification;
    }

    public int getIdUser() {
        return userQuiAchange;
    }	

    public ReservationDTO getReservation() {
        return reservation;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
    }

    /**indique qui a modifie la reservation
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.userQuiAchange = idUser;
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