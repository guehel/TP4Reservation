package services;

import java.rmi.RemoteException;
import java.util.List;

import reservation.dto.ChambreDTO;
import testStevie.SteveServicesWeb;
import entities.Room;
import entities.RoomFactory;

public class RoomService

{
	private static RoomService instance;
	private SteveServicesWeb webService;
	private RoomFactory factory = new RoomFactory();

	private RoomService() {
	}

	public static RoomService getInstance() {
		if (instance == null) {
			instance = new RoomService();
		}

		return instance;
	}

	public List<Room> query() {

		List<Room> list = null;
		try {

		//	ChambreDTO[] chambres = webService.obtenirListeChambre();
		//	System.out.println(chambres[1].getNumeroChambre());
			list = factory.getList(webService.obtenirListeChambre());

		} catch (RemoteException e) {
			e.printStackTrace();
		}
		for (Room room : list) {

			System.out.println(room.getId());
		}
		return list;
	}

	public Room get(long id) {
		return null;
	}

	public void update(Room room) {

	}

	public void setWebService(SteveServicesWeb steveServicesWeb) {
		webService = steveServicesWeb;
	}
}
