/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reservation;

import java.util.ArrayList;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import reservation.donnes.*;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;

/**
 *
 * @author boug18087415
 */
public class ReservationHelper {

    private Session session = null;

    public ReservationHelper() {
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }

    /**
     * se connecte a la base de donnee et liste les chambre reservee
     */
    public ChambreDTO[] getAvailableRoom() {
        ArrayList<Chambre> listeDesChambre = null;
        ChambreDTO[] listeChambresDTO = null;
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery(
                    "from Chambre as chambre "
            );
            listeDesChambre = (ArrayList<Chambre>) q.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (listeDesChambre != null) {
            listeChambresDTO = new ChambreDTO[listeDesChambre.size()];
            for (int i = 0; i < listeDesChambre.size(); i++) {
                listeChambresDTO[i] = new ChambreDTO(listeDesChambre.get(i));
            }
        }

        return listeChambresDTO;
    }

    public Reservation getNewRervation(Chambre chambre) {
        return new Reservation(new ReservationId(), chambre);
    }

    public void saveReservation(Reservation reservation) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(reservation);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /*renvoie la liste des chambes sous forme de dto*/
    public ChambreDTO[] obtenirListeChambre(){
    return null;}
     /*renvoie la liste des chambes sous forme de dto pour un client donnee*/
    public ChambreDTO[] obtenirListeChambre(int idClient){
    return null;}
    
     /*renvoie la liste des chambes sous forme de dto*/
     public ClientDTO[] obtenirListeClients(int idClient){
    return null;}
     
     
     public boolean update(ChambreDTO chambreDto){
     return false;}
    
    public Client getNewClient() {
        Client client = null;
        client = new Client();
        return client;
    }

    public void saveClient(Client client) {
        try {
            Transaction tx = session.beginTransaction();
            session.save(client);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
