/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reservation.dto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import reservation.DTOFactory;
import reservation.donnes.Reservation;

/**
 *
 * @author boug18087415
 */
public class ReservationDTO {
    
    private int idReservation ;
    private int idChambre;
    private ClientDTO clientDTO;
    private String creation;
    private String arrivee;
    private String depart;

    public  ReservationDTO(Reservation reservation){
        idReservation = reservation.getId().getIdReservation();
        idChambre = reservation.getChambre().getNumero();
        clientDTO = DTOFactory.getClientDTO(reservation.getClient());
        creation = formaterDate(reservation.getDateCreation());
        arrivee = formaterDate(reservation.getArrivee());
        depart = getDateDepart(reservation);
    }
    
    public  ReservationDTO(){
         idReservation = 0;
        idChambre = 0;
        clientDTO = null;
        creation = "";
        arrivee = "";
        depart = "";
    }
    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public int getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(int idChambre) {
        this.idChambre = idChambre;
    }

    public ClientDTO getClientDTO() {
        return clientDTO;
    }

    public void setClientDTO(ClientDTO clientDTO) {
        this.clientDTO = clientDTO;
    }

    public String getCreation() {
        return creation;
    }

    public void setCreation(String creation) {
        this.creation = creation;
    }

    public String getArrivee() {
        return arrivee;
    }

    public void setArrivee(String arrivee) {
        this.arrivee = arrivee;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }
    private String getDateDepart(Reservation reservation){
        Date dateArrivee = reservation.getArrivee();
        Long duree = dateArrivee.getTime();
        Long departMs = duree + (reservation.getSejour()*24*60*60*1000);
        Date depart = new Date(departMs);
        return formaterDate(depart);
    }
    
    private String formaterDate(Date date){
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String reportDate = df.format(date);
        return reportDate;
    }
}
