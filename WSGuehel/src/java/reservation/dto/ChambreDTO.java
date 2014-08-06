/*

 */

package reservation.dto;

import reservation.donnes.Chambre;

/**
 *
 * @author boug18087415
 */
public class ChambreDTO {
    private int numeroChambre;
    private ReservationDTO[] reservations;
    private Formulaire formulaire;
    public ChambreDTO(Chambre chambre){
        numeroChambre = chambre.getNumero();
      //  reservations  = (ReservationDTO[])chambre.getReservations().toArray();
       System.out.print(chambre.getReservations().getClass().getName()+"*");
        formulaire = new Formulaire();
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public ReservationDTO[] getReservations() {
        return reservations;
    }

    public void setReservations(ReservationDTO[] reservations) {
        this.reservations = reservations;
    }

    public Formulaire getFormulaire() {
        return formulaire;
    }

    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
    }
    
    
}
