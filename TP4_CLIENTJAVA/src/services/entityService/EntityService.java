package services.entityService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entities.Room;

public class EntityService

{
	private static Map<ServiceableEntityTypes, EntityService> serviceInstances = new HashMap<ServiceableEntityTypes, EntityService>();

	private EntityService(){}

	public static EntityService getService(ServiceableEntityTypes entityType)
	{
		EntityService instance = serviceInstances.get(entityType);
		;

		if (instance == null)
		{
			instance = new EntityService();
			serviceInstances.put(entityType, instance);
		}

		return instance;
	}
	
	public List<ServiceableEntityInterface> query()
	{
		List<ServiceableEntityInterface> list = new ArrayList<ServiceableEntityInterface>();
		Room room1 = new Room();
		room1.setId(1);
		list.add(room1);
		
		Room room2 = new Room();
		room2.setId(2);
		list.add(room2);
		
		Room room3 = new Room();
		room3.setId(3);
		list.add(room3);
		
		Room room4 = new Room();
		room4.setId(4);
		list.add(room4);
	
		return list;
	}

	public ServiceableEntityInterface get(long id)
	{
		return null;
	}

	public void put(ServiceableEntityInterface querableEntity)
	{
		//rooms.put(querableEntity.getId(), querableEntity);
	}
}
