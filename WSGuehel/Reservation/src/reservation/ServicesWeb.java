package reservation;

import java.sql.SQLException;
import java.util.ArrayList;

import org.joda.time.DateTime;
import org.joda.time.Interval;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.EntiteDTO;
import reservation.dto.Formulaire;
import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;
import reservation.objects.Client;
import reservation.objects.Reservation;

public class ServicesWeb implements Services {
	private DAOFactory daoFactory = null;
	private GrandLivre grandLivre ;
	public  ServicesWeb () throws ClassNotFoundException, SQLException{
		super();
		daoFactory = new DAOFactory();
		grandLivre = new GrandLivreHotel();
	}

	@Override
	public ChambreDTO[] obtenirListeChambre() {
		ChambreDAO chambreDAO = ((ChambreDAO) daoFactory.getDAO(Table.CHAMBRE));
		ArrayList<Chambre> listeChambres = chambreDAO.getAllChambres();
		int n = listeChambres.size();
		if(n!=0){
			ChambreDTO[] retour = new ChambreDTO[n];
			for(int i = 0; i< n; i++ ){
				Chambre chambre = listeChambres.get(i);
				ChambreDTO chambreDTO = new ChambreDTO(chambre);
				ReservationDTO[] listeResChambre = 
						EntiteDTO.getReservationsFromSet(
								grandLivre.getReservations(chambre)
						);
				chambreDTO.setReservations(listeResChambre);
				retour[i] = chambreDTO;
			}
			return retour;
		}
		return null;
	}


	@Override
	public ClientDTO[] obtenirListeClients() {
		ClientDAO clientDAO = ((ClientDAO) daoFactory.getDAO(Table.CLIENT));
		ArrayList<Client> listeClients = clientDAO.getAllClients();
		int n = listeClients.size();
		if(n!=0){
			ClientDTO[] retour = new ClientDTO[n];
			for(int i = 0; i< n; i++ ){
				Client client = listeClients.get(i);
				ClientDTO clientDTO = new ClientDTO(client);
				ReservationDTO[] listeResclient = 
						EntiteDTO.getReservationsFromSet(
								grandLivre.getReservations(client)
						);
				clientDTO.setReservations(listeResclient);
				retour[i] = clientDTO;
			}
			return retour;
		}
		return null;
	}

	@Override
	public boolean update(ChambreDTO chambreDTO) {
		boolean reussie = false;
		
		Formulaire formulaireModif = chambreDTO.getFormulaire();

		try {
			Reservation reservation = formulaireModif.getReservationFromDTO();
			reussie = 	grandLivre.modifierChambre(reservation, formulaireModif.getType());
		} catch (Exception e) {
			
		}
		
	

		return reussie;
	}


	@Override
	public ReservationDTO[] obtenirReservations(int idClient) {
		ReservationDTO[] listeReservation = null;
		Client client = ((ClientDAO) daoFactory.getDAO(Table.CLIENT)).findById(idClient);
		if(client!=null){
			
			listeReservation = EntiteDTO.getReservationsFromSet(
					grandLivre.getReservations(client)
					);
			
		
		}
		return listeReservation;
	}

}
