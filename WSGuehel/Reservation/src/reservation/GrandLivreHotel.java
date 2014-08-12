package reservation;

import java.sql.SQLException;
import java.util.ArrayList;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dao.ReservationDAO;
import reservation.dto.ChambreDTO;
import reservation.dto.ReservationDTO;
import reservation.entites.Entite;
import reservation.entites.EntiteChambre;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class GrandLivreHotel extends Entite {

	private ArrayList<Client> listeClients;
	private ArrayList<Chambre> listeChambre;
	private DAOFactory factory = null;
	private Entite contenantResultat;
	private ChambreDTO[] listeChambreDTOs;

	public GrandLivreHotel() {

		DAO<?> dao = null;
		try {
			factory = new DAOFactory();
			dao = factory.getDAO(Table.RESERVATION);
			reservations = ((ReservationDAO) dao).getAllReservations();
			dao = factory.getDAO(Table.CLIENT);
			listeClients = ((ClientDAO) dao).getAllClients();
			dao = factory.getDAO(Table.CHAMBRE);
			listeChambre = ((ChambreDAO) dao).getAllChambres();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public Client getClient(int idClient) {
		for (Client client : listeClients) {
			if (client.getIdClient() == idClient)
				return client;
		}
		return null;

	}

	public Chambre getChambre(int numeroDeChambre) {
		for (Chambre chambre : listeChambre) {
			if (chambre.getNumeroChambre() == numeroDeChambre)
				return chambre;
		}
		return null;
	}

	public ArrayList<Client> getListeClients() {
		return listeClients;
	}

	public ArrayList<Chambre> getListeChambre() {
		return listeChambre;
	}

	public boolean contains(Reservation reservation) {

		return this.reservations.contains(reservation);
	}

	public boolean isValide() {

		return this.listeChambre.size() > 0;
	}

	public ReservationDTO[] rechercheReservations(int client) {
		this.contenantResultat = new Entite();
		for (Reservation reservation : this.getReservations()) {
			if (reservation.getClient().getIdClient() == (client)) {
				this.contenantResultat.ajouterReservation(reservation);

			}
		}
		return this.contenantResultat.getReservationsArray();
	}

	public ReservationDTO[] rechercheReservations(Chambre chambre) {
		this.contenantResultat = new Entite();
		for (Reservation reservation : this.getReservations()) {
			if (reservation.getChambre().equals(chambre)
			// && reservation.getInterval().contains(now)
			) {
				this.contenantResultat.ajouterReservation(reservation);
			}
		}
		return this.contenantResultat.getReservationsArray();
	}

	public ChambreDTO[] rechercherChambres() {

		this.listeChambreDTOs = new ChambreDTO[this.listeChambre.size()];
		int i = 0;

		for (Chambre chambre : this.listeChambre) {

			this.listeChambreDTOs[i] = new EntiteChambre(chambre)
					.getChambreDTO();

			ReservationDTO[] reservationsChambre = this
					.rechercheReservations(chambre);

			this.listeChambreDTOs[i].setReservations(reservationsChambre);

			i++;
		}
		return listeChambreDTOs;

	}

}
