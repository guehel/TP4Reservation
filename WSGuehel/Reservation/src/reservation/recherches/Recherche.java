/**
 * 
 */
package reservation.recherches;

import java.util.TreeSet;

/**Interface pour les differente rechers
 * @author Guehel
 *
 */
public interface  Recherche <T> {
	TreeSet<T> rechercher();
}
