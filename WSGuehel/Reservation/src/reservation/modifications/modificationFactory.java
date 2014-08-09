package reservation.modifications;

import java.sql.SQLException;

public class modificationFactory {

	public static Modification getModifications(int type) {
		Modification modification = null;
		switch(type){
		case 1: 
			try {
				modification = new AjoutReservation();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				break;
			}
			break;
		case 0:
			try {
				modification = new SuppressionReservation();
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
