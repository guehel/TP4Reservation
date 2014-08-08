package reservation;

import java.sql.SQLException;
import java.util.ArrayList;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAOFactory;
import reservation.dao.DAOFactory.Table;
import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.EntiteDTO;
import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;
import reservation.objects.Client;

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
				retour[i] = new ChambreDTO(listeChambres.get(i));
			}
			return retour;
		}
		return null;
	}


	@Override
	public ClientDTO[] obtenirListeClients() {
		// Test webservice
		ClientDTO client = new ClientDTO();
		client.setId(1);
		client.setNom("Bouanga");
		client.setPrenom("Guehel");
		ReservationDTO resa = new ReservationDTO();
		resa.setArrivee("25 mai");
		resa.setDepart("23-Juin");
		resa.setCreation("01 jan");
		resa.setIdReservation(1);
		ReservationDTO[] res = {resa};
		client.setReservations(res);
		ClientDTO[] tabClients = {client};
		return tabClients;
	}

	@Override
	public boolean update(ChambreDTO chambre) {
		// Test webservice
		System.out.println("num "+chambre.getNumeroChambre());
		System.out.println("num date "+chambre.getFormulaire().getDateModification());
		System.out.println("depart "+chambre.getReservations()[0].getDepart());

		return true;
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
