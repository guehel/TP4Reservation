package reservation.objects;

import java.util.Comparator;

import reservation.dao.OutilsDates;

/**Classe servant a comparer 2 reservations pour les trier selon l'ordre chronologique dans un set
 * @author boug18087415
 *
 */
public class ComparateurReservation implements Comparator<Reservation> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(Reservation o1, Reservation o2) {
		
		return OutilsDates.CompareEntreInterval(o1.getInterval(), o2.getInterval());
	}
}
