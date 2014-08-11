package reservation.modifications;

import java.sql.SQLException;

import reservation.GrandLivreHotel;
import reservation.SingleGrandLivre;


public class modificationFactory {
	private static GrandLivreHotel grandLivre  = SingleGrandLivre.getInstance();
		

	public static Modification getModifications(int type) {
		Modification modification = null;
		switch(type){
		case 1: 
			try {
				modification = new AjoutReservation(grandLivre);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				break;
			}
			break;
		case 0:
			try {
				modification = new SuppressionReservation(grandLivre);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				break;
			}
			break;
		default:
			break;
		}
		return modification;
	}



}
