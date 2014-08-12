package reservation.recherches;

import reservation.objects.Chambre;
import reservation.objects.Client;

public class RechercheFactory {

	public static RechercheReservation getRechercheReservation(Client client) {

		return new ReservationsParClient(client.getIdClient());

	}

	public static RechercheReservation getRechercheReservation(Chambre chambre) {

		return new ReservationsParChambre(chambre);

	}

	public static RechercheReservation getRechercheReservation(int idClient) {

		return new ReservationsParClient(idClient);

	}

	public static RechercheClients getRechercheClient() {

		return new ToutsClients();
	}

	public static RechercheChambres getRechercheChambres() {

		return new ToutesChambres();
	}

}
