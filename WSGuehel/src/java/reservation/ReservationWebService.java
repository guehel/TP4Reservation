/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reservation;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import reservation.donnes.Chambre;
import reservation.dto.ChambreDTO;

/**
 *
 * @author boug18087415
 */
@WebService(serviceName = "ReservationWebService")
@Stateless()
public class ReservationWebService {

    /**
     * This is a sample web service operation
     * @return 
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "listeChambre")
    public ChambreDTO[] listeChambre() {
        ReservationHelper reservation = new ReservationHelper();
        ChambreDTO[] liste  = reservation.getAvailableRoom();
        System.out.println(liste.length);
//        return liste.get(0).getNumero();
        return liste;
    }
}
