package reservation.objects;




public class Chambre extends Entite {
	 private int numeroChambre;

	public Chambre() {
	super();	

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
		return numeroChambre == chambre.getNumeroChambre();
	}
	
	

	
	
}
