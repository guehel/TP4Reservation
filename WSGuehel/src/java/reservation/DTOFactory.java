/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reservation;

import reservation.donnes.*;
import reservation.dto.*;

/**
 *
 * @author boug18087415
 */
public class DTOFactory {
    public static ClientDTO getClientDTO(Client client ){
        ClientDTO clientDTO = new ClientDTO(client);
    return clientDTO;}
    
     public static Client getClient(ClientDTO clientDto ){
         Client client = new Client();
    return null;}
     
      public static ReservationDTO getReservationDTO(Reservation client ){
    return null;}
      
          public static Reservation getReservation(ReservationDTO reservationDTO ){
    return null;}
          
             public static ChambreDTO getChambreDTO(Chambre client ){
    return null;}
      
          public static Reservation getChambre(ChambreDTO chambreDTO ){
    return null;}
}
