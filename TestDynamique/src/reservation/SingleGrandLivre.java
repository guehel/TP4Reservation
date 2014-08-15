package reservation;



public class SingleGrandLivre {
	private static GrandLivreHotel grandLivre;

	public static GrandLivreHotel getInstance() {
		if (grandLivre == null) {
			grandLivre = new GrandLivreHotel();
			if (!grandLivre.isValide())
				grandLivre = null;
		}
		return grandLivre;
	}

}
