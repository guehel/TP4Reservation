package reservation.dto;

import reservation.entites.EntiteReservation;
import reservation.objects.Chambre;

public class ChambreDTOWeb extends ChambreDTO{
private EntiteDTO entite;
private Formulaire formulaire;


public ChambreDTOWeb() {
	super();
	formulaire = new Formulaire();
}

public ChambreDTOWeb(Chambre chambre) {
	super(chambre);
//	reservations = new ReservationDTO[chambre.getNombreReservation()];
}
@Override
public void setFormulaire(Formulaire formulaire) {
    this.formulaire = formulaire;
}

@Override
public ReservationDTO[] getReservations() {
	// TODO Auto-generated method stub
	return entite.getReservations();
}

@Override
public void setReservations(ReservationDTO[] reservations) {
	entite = new EntiteDTO(reservations);
	
}

@Override
public Formulaire getFormulaire() {
	// TODO Auto-generated method stub
	return formulaire;
}
}
