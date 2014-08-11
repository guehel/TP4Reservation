package reservation;

import reservation.dto.ChambreDTO;
import reservation.dto.ClientDTO;
import reservation.dto.ReservationDTO;

public class FacadeServiceWeb implements Services {
	
	
	
	public  FacadeServiceWeb(){}

	@Override
	public ChambreDTO[] obtenirListeChambre() {
		Services service = SingleServiceWeb.getInstance();
		if(service==null)
		return null;
		else{
			return service.obtenirListeChambre();
		}
	}

	@Override
	public ReservationDTO[] obtenirReservations(int idClient) {
		Services service = SingleServiceWeb.getInstance();
		if(service==null)
		return null;
		else{
			return service.obtenirReservations(idClient);
		}
	}

	@Override
	public ClientDTO[] obtenirListeClients() {
		Services service = SingleServiceWeb.getInstance();
		if(service==null)
		return null;
		else{
			return service.obtenirListeClients();
		}
	}

	@Override
	public boolean update(ChambreDTO chambreDTO) {
		Services service = SingleServiceWeb.getInstance();
		if(service==null)
		return false;
		else{
			return service.update(chambreDTO);
		}
	}

}
