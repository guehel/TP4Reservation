package reservation;

import java.sql.SQLException;
import java.util.ArrayList;


import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;
import reservation.entites.Entite;

import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;


public class GrandLivreHotel extends Entite {
	
	
	private ArrayList<Client> listeClients;
	private ArrayList<Chambre> listeChambre;
	private DAOFactory factory = null;
	public GrandLivreHotel(){
		
		DAO<?> dao = null;	
		try {
			factory  = new DAOFactory();
			dao = (ReservationDAO)factory.getDAO(Table.RESERVATION);
			reservations = ((ReservationDAO) dao).getAllReservations();
			dao = (ClientDAO)factory.getDAO(Table.CLIENT);
			listeClients = ((ClientDAO) dao).getAllClients();
			dao = (ChambreDAO)factory.getDAO(Table.CHAMBRE);
			listeChambre = ((ChambreDAO) dao).getAllChambres();
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	public Client getClient(int idClient){
		for(Client client: listeClients){
			if(client.getIdClient() == idClient)return client;
		}
		return null;
		
	}
	
	public Chambre  getChambre(int numeroDeChambre) {
		for(Chambre chambre: listeChambre){
			if(chambre.getNumeroChambre()== numeroDeChambre)return chambre;
		}
		return null;
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}

	public ArrayList<Chambre> getListeChambre() {
		return listeChambre;
	}
	
	
	public void addReservation(Reservation Reservation){
		
	this.reservations.add(Reservation);
		
	}

	public boolean contains(Reservation reservation) {
		
		return this.reservations.contains(reservation);
	}

	public boolean isValide() {
		
		return this.listeChambre.size()>0  ;
	}
	



}
