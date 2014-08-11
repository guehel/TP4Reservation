package reservation.recherches;


import reservation.GrandLivreHotel;
import reservation.SingleGrandLivre;
import reservation.objects.Chambre;
import reservation.objects.Client;



public class RechercheFactory{
	private static GrandLivreHotel grandLivre  = SingleGrandLivre.getInstance();
	
	public static RechercheReservation  getRechercheReservation(Client client){
		
		return new ReservationsParClient(grandLivre, client);
		
	}
	
	public static RechercheReservation  getRechercheReservation(Chambre chambre){
		
			return new ReservationsParChambre(grandLivre, chambre);
	
	}
	
	public static RechercheReservation  getRechercheReservation(int idClient){
		Client client = grandLivre.getClient(idClient);
		return new ReservationsParClient(grandLivre, client);

	}
	
	public static RechercheClients getRechercheClient() {
		
		return new ToutsClients(grandLivre);
	}
	
	public static RechercheChambres getRechercheChambres() {
		
		return new ToutesChambres(grandLivre);
	}
	


}
