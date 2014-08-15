package reservation.arbre;

import reservation.objects.Reservation;

public class ArbreBinaireReservations {
	private NoeudReservations racine = null;

	public ArbreBinaireReservations() {
		racine = null;
	}

	public boolean arbreVide() {
		return racine == null;
	}

	public void vider() {
		racine = null;
		System.gc();
	}

	private NoeudReservations rechercherNoeud(NoeudReservations actuel,
			Reservation obj) {
		NoeudReservations retour = null;
		// Si le noeud actuel n'est pas null
		if (actuel != null) {
			// Si le noeud actuel est le noeud recherché
			if (actuel.getTeteReservation().equals(obj)) {
				retour = actuel;
			} else {
				// Rechercher avec le noeud fils du noeud actuel
				retour = rechercherNoeud(actuel.getPrecedent(), obj);
				// Rechercher avec le noeud frère du noeud actuel
				if (retour == null) {
					retour = rechercherNoeud(actuel.getSuivant(), obj);
				}
			}
		}
		return retour;
	}

	public boolean contains(Reservation obj) {
		// Vrai si la recherche retourne quelque chose, faux sinon
		return (rechercherNoeud(this.racine, obj) != null);
	}

	public boolean ajouter(Reservation obj, Reservation pParent) {
		NoeudReservations parent = null;
		NoeudReservations frere = null;
		boolean reussite = false;

		// Si paramParent est null
		if (pParent == null || !pParent.equals(obj)) {
			// Si arbre vide
			if (arbreVide()) {
				this.racine = new NoeudReservations(obj);

			} else {
				this.racine.setSuivant(new NoeudReservations(obj, null,
						this.racine.getSuivant()));
			}

			reussite = true;
		}
		// Si pParent est différent de null
		else {
			// Si arbre n'est pa vide
			if (!arbreVide()) {
				// Rechercher le noeud parent
				parent = rechercherNoeud(this.racine, pParent);

				// Si le noeud parent existe
				if (parent != null) {
					// Si le parent a des fils, parcourir les
					// fils, et ajouter le nouveau
					// noeud comme frère du dernier fils
					if (parent.getPrecedent() != null) {
						frere = parent.getPrecedent();

						while (frere.getSuivant() != null) {
							frere = frere.getSuivant();
						}

						frere.setSuivant(new NoeudReservations(obj));
					}
					// S'il n'a pas de fils, ajouter le noeud
					// comme fils du parent
					else {
						parent.setPrecedent(new NoeudReservations(obj));
					}
					// Si l'ajout est réussi
					reussite = true;
				}
			}
		}
		return reussite;
	}

	public String parcoursPrefixe() {
		return prefixe(this.racine);
	}

	private String prefixe(NoeudReservations nCourant) {
		String chaine = "";
		if (nCourant != null) {
			chaine += nCourant.getTeteReservation() + ", ";
			chaine += prefixe(nCourant.getSuivant());
			chaine += prefixe(nCourant.getPrecedent());
		}

		return chaine;
	}

	private int prefixeInt(NoeudReservations nCourant) {
		int chaine = 0;
		if (nCourant != null) {
			chaine += nCourant.getTeteReservation() != null ? 1 : 0;
			chaine += prefixeInt(nCourant.getSuivant());
			chaine += prefixeInt(nCourant.getPrecedent());
		}

		return chaine;
	}

	public boolean add(Reservation reservation) {

		if (this.racine == null) {
			this.racine = new NoeudReservations(reservation);
			return true;
		}
		return this.ajouter(reservation, this.racine.getTeteReservation());

	}

	/**
	 * @param reservation
	 */
	public void remove(Reservation reservation) {
		if (contains(reservation)) {
			NoeudReservations nResa = rechercherNoeud(racine, reservation);
			remove(nResa, reservation);
		}

	}

	/**
	 * fonction recursive de suppression de noeud
	 * 
	 * @param noeud
	 *            contenant la reservation
	 * @param reservation
	 *            resrvation a supprimer
	 */
	private void remove(NoeudReservations noeud, Reservation reservation) {

		if (noeud != null) {
			if (noeud.getPrecedent() != null) {
				noeud.getPrecedent().setSuivant(noeud.getSuivant());
				if (noeud.getSuivant() != null) {
					noeud.getSuivant().setPrecedent(noeud.getPrecedent());

				}
			} else {
				// noeud.setPrecedent(null);
				noeud = noeud.getSuivant();

			}
		}

	}

	public int size() {
		int n = prefixeInt(this.racine);
		return n;
	}

	public Reservation rechercher(Reservation parametreRecheche) {
		NoeudReservations retour = rechercherNoeud(this.racine,
				parametreRecheche);
		return retour == null ? null : retour.getTeteReservation();
	}

	public Reservation[] toArray() {
		int taille = this.size();
		Reservation[] reservatios = new Reservation[taille];
		int indice = 0;
		reservatios = inserer(reservatios, racine, indice);
		return reservatios;
	}

	private Reservation[] inserer(Reservation[] tab, NoeudReservations actuel,
			int indice) {
		if (actuel != null) {
			tab[indice] = actuel.getTeteReservation();
			tab = inserer(tab, actuel.getPrecedent(), indice++);
			tab = inserer(tab, actuel.getSuivant(), indice++);
		}
		return tab;
	}
}
