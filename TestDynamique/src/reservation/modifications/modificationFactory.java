package reservation.modifications;


public class modificationFactory {

	public static Modification getModifications(int type) {
		Modification modification = null;
		switch (type) {
		case 1:
			modification = new AjoutReservation();
			break;
		case 0:
			modification = new SuppressionReservation();
			break;
		default:
			break;
		}
		return modification;
	}

}
