package reservation.dto;


/*
**
*Formulaire charger de receuiller les reservation et les annulations
* @author boug18087415
*/
public class Formulaire {
    private String dateModification="";
    private int modifiant=0;
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

   

    public int getModifiant() {
		return modifiant;
	}




	public void setModifiant(int modifiant) {
		this.modifiant = modifiant;
	}




	public ReservationDTO getReservation() {
        return reservation;
    }

    public void setDateModification(String dateModification) {
        this.dateModification = dateModification;
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