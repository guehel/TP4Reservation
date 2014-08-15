package reservation.objects;

import reservation.entites.Entite;




public class Chambre extends Entite {
	 private int numeroChambre;

	public Chambre() {
	super();	

	}
	public Chambre(int numeroChambre) {
		super();
		this.numeroChambre = numeroChambre;
	}
	public int getNumeroChambre() {
		return numeroChambre;
	}
	public void setNumeroChambre(int numeroChambre) {
		this.numeroChambre = numeroChambre;
	}
	@Override
	public boolean equals(Object obj) {
		Chambre chambre = (Chambre)obj;
		boolean b =  numeroChambre == chambre.getNumeroChambre();
		System.out.println(numeroChambre +(b?" egale ":" diff ") + chambre.getNumeroChambre());
		return b;
	}
	public int getNombreReservation() {
		return this.reservations.size();
	}
	
	

	
	
}
