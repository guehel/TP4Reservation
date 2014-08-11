package entities;

import java.util.ArrayList;
import java.util.List;

import reservation.dto.ChambreDTO;
import reservation.dto.Formulaire;

public class RoomFactory {
	
	public List<Room> getList(ChambreDTO[] chambreList) {
		
		List<Room> roomList = new ArrayList<Room>();
		
		for (ChambreDTO chambre : chambreList)
		{
			Room newRoom = new Room();
			newRoom.setId(chambre.getNumeroChambre());
			newRoom.setFormulaire(this.getForm(chambre.getFormulaire()));
			roomList.add(newRoom);
		}
			
		return roomList;
	}

	private RoomForm getForm(Formulaire formulaire) {
		RoomForm newRoomForm = new RoomForm();
		return newRoomForm;
	}

}
