package services;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import reservation.dto.ClientDTO;
import testStevie.SteveServicesWeb;
import entities.Client;
import entities.EntityFactory;

public class ClientService

{
	private static ClientService			instance;
	private SteveServicesWeb				webService;
	private final EntityFactory				factory			= new EntityFactory();
	private final Map<Long, Client>			clientMap		= new ConcurrentHashMap<>();
	private final Map<Integer, ClientDTO>	clientDTOMap	= new ConcurrentHashMap<>();

	/**
	 * Constructeur privé du ClientService.
	 */
	private ClientService()
	{
	}

	/**
	 * Acceseur de l'instance de ClientService.
	 * 
	 * @return l'instance de ClientService.
	 */
	public static ClientService getInstance()
	{
		if (instance == null)
		{
			instance = new ClientService();
		}

		return instance;
	}

	/**
	 * Retourne la liste de Client.
	 * 
	 * @return la liste de Client.
	 */
	public List<Client> query()
	{
		try
		{
			ClientDTO[] clientDTOlist = webService.obtenirListeClients();
			for (ClientDTO clientDTO : clientDTOlist)
			{
				clientDTOMap.put(clientDTO.getId(), clientDTO);
				Client newClient = factory.convertClientDTO(clientDTO);
				clientMap.put(newClient.getId(), newClient);
			}

		} catch (RemoteException e)
		{
			e.printStackTrace();
		}

		return new ArrayList<Client>(clientMap.values());
	}

	/**
	 * Retourne un client selon son id.
	 * 
	 * @param id
	 *            , l'id du client.
	 * @return le client.
	 */
	public Client get(long id)
	{
		return clientMap.get(id);
	}

	/**
	 * Retroune un clientDTO selon son id.
	 * 
	 * @param id
	 *            , l'id du clientDTO.
	 * @return le ClientDTO.
	 */
	public ClientDTO getDTO(long id)
	{
		return clientDTOMap.get(id);
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
