package reservation.recherches;

import reservation.objects.Client;

public class RechercheFactory {

	public static RechercheReservation getRechercheReservation(Client client) {

		return new ReservationsParClient(client.getIdClient());

	}

	public static RechercheReservation getRechercheReservation(int idClient) {
		String parametre = idClient + "";

		if (parametre.charAt(0) == '9') {
			int numeroChambre = idClient % 900;
			System.out.println(numeroChambre + " la recherche porte dessus");
//			return new ReservationsParChambreTest(numeroChambre);
			return new ReservationsParChambre(numeroChambre);
		}
		return new ReservationsParClient(idClient);

	}

	public static RechercheClients getRechercheClient() {

		return new ToutsClients();
	}

	public static RechercheChambres getRechercheChambres() {

		return new ToutesChambres();
	}

}
