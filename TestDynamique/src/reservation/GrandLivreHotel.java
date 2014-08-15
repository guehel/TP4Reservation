package reservation;

import java.sql.SQLException;
import java.util.ArrayList;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAO;
import reservation.dao.DAOFactory;
import reservation.dao.ReservationDAO;
import reservation.dto.ChambreDTO;
import reservation.dto.ChambreDTOWeb;
import reservation.dto.ReservationDTO;
import reservation.entites.Entite;
import reservation.entites.EntiteChambre;
import reservation.entites.EntiteReservation;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class GrandLivreHotel extends Entite {

	private ArrayList<Client> listeClients;
	private ArrayList<Chambre> listeChambre;
	private DAOFactory factory = null;
	private Entite contenantResultat;
	private ChambreDTO[] listeChambreDTOs;
	protected DAO<?> dao;

	public GrandLivreHotel() {

		try {
			factory = new DAOFactory();
			dao = factory.getDAO(DAOFactory.Table.CLIENT);
			listeClients = ((ClientDAO) dao).getAllClients();
			dao = factory.getDAO(DAOFactory.Table.CHAMBRE);
			listeChambre = ((ChambreDAO) dao).getAllChambres();
			dao = factory.getDAO(DAOFactory.Table.RESERVATION);
//			reservations = ((ReservationDAO) dao).getAllReservations();
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}
	}

	public void loadReservations() {

		reservations = ((ReservationDAO) dao).getAllReservations();

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

	public boolean isValide() {

		return this.listeChambre.size() > 0;
	}

	public ReservationDTO[] rechercheReservationsClient(int idClient) {
	
		super.reservations = ((ReservationDAO) dao).getClientReservations(idClient);
		return super.getReservationsArray();
	}

	public ReservationDTO[] rechercheReservationsParNumchambre(int numeroChambre) {
		super.reservations = ((ReservationDAO) dao).getRoomReservations(numeroChambre);
		return super.getReservationsArray();
	}

	public ChambreDTOWeb[] rechercherChambres() {

		this.listeChambreDTOs = new ChambreDTOWeb[this.listeChambre.size()];
		int i = 0;

		for (Chambre chambre : this.listeChambre) {

			this.listeChambreDTOs[i] = new EntiteChambre(chambre)
					.getChambreDTO();

//			ReservationDTO[] reservationsChambre = this
//					.rechercheReservationsParNumchambre(chambre
//							.getNumeroChambre());

//			this.listeChambreDTOs[i].setReservations(reservationsChambre);

			i++;
		}
		return (ChambreDTOWeb[]) listeChambreDTOs;

	}

	public boolean effectuerAJout(ReservationDTO reservationDTO) {
		boolean ok =false;
		try {
			EntiteReservation entite;
			entite = new EntiteReservation(reservationDTO);
			Reservation reservation = entite.getReservation();
			 ok = ((ReservationDAO) dao).create(reservation );
		} catch (Exception e) {
				e.printStackTrace();
		}
	
		return ok;
	}

	public boolean effectuerSuppression(ReservationDTO reservationDTO) {
		boolean valide = (reservationDTO != null);
		if (valide) {
			EntiteReservation entite = null;
			try {
				entite = new EntiteReservation(reservationDTO);
				Reservation reservation = entite.getReservation();

				if (valider(reservation)) {
					dao = factory.getDAO(DAOFactory.Table.RESERVATION);
					valide = ((ReservationDAO) dao).delete(reservation);
					if (valide)
						this.supprimerReservation(reservation);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return valide;
	}

	@Override
	protected boolean valider(Reservation preservation) {
		boolean valide = super.valider(preservation);
		if (valide) {
		//ici on valide qui a le droit de supprimer

		}
		return valide;
	}
}
