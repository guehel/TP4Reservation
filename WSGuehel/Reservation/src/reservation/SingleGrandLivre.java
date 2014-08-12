package reservation;

//a commenter si ca ne marche pas
import reservation.arbre.GrandLivreHotel;

public class SingleGrandLivre {
	private static reservation.arbre.GrandLivreHotel grandLivre;

	public static GrandLivreHotel getInstance() {
		if (grandLivre == null) {
			grandLivre = new GrandLivreHotel();
			if (!grandLivre.isValide())
				grandLivre = null;
		}
		return grandLivre;
	}

}
