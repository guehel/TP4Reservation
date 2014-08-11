package services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import reservation.dto.ChambreDTO;
import testStevie.SteveServicesWeb;
import entities.EntityFactory;
import entities.Room;

/**
 * Sert de tampon entre le webService et l'application
 * 
 * @author Steve Boisvert.
 * 
 */
public class RoomService

{
	private static RoomService				instance;
	private SteveServicesWeb				webService;
	private final EntityFactory				factory		= new EntityFactory();
	private final Map<Long, Room>			roomMap		= new ConcurrentHashMap<>();
	private final Map<Integer, ChambreDTO>	chambreMap	= new ConcurrentHashMap<>();

	/**
	 * Constructeur privé du RoomService.
	 */
	private RoomService()
	{
	}

	/**
	 * Retroune l'instance du RoomService.
	 * 
	 * @return le RoomService.
	 */
	public static RoomService getInstance()
	{
		if (instance == null)
		{
			instance = new RoomService();
		}

		return instance;
	}

	/**
	 * Retourne la liste des chambres.
	 * 
	 * @return la liste des chambres.
	 */
	public List<Room> query()
	{
		try
		{
			ChambreDTO[] chambreDTOlist = webService.obtenirListeChambre();
			for (ChambreDTO chambreDTO : chambreDTOlist)
			{
				chambreMap.put(chambreDTO.getNumeroChambre(), chambreDTO);
				Room newRoom = factory.convertChambreDTO(chambreDTO);
				roomMap.put(newRoom.getId(), newRoom);
			}

		} catch (RemoteException e)
		{
			e.printStackTrace();
		}

		return new ArrayList<Room>(roomMap.values());
	}

	/**
	 * Retourne une chambre selon son id.
	 * 
	 * @param id
	 *            , l'id de la chambre.
	 * @return la chambre.
	 */
	public Room get(long id)
	{
		// Mise à jour de la liste.
		query();

		return roomMap.get(id);
	}

	/**
	 * Soumet le formulaire d'ajout ou suppression de réservation au serveur.
	 * 
	 * @param room
	 *            , la chambre sujette au changement.
	 * @return vrai si le chamgement à été accepté par le serveur.
	 */
	public boolean submitForm(Room room)
	{
		boolean success = false;
		try
		{
			ChambreDTO chambreDTO = chambreMap.get(room.getId());
			chambreDTO.setFormulaire(factory.convertRoomForm(room
					.getFormulaire()));
			success = webService.update(chambreDTO);
		} catch (RemoteException e)
		{
			success = false;
			e.printStackTrace();
		}

		return success;
	}

	/**
	 * Mutateur du service web.
	 * 
	 * @param webService
	 *            , le service web.
	 */
	public void setWebService(SteveServicesWeb webService)
	{
		this.webService = webService;
	}
}