package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.Room;

public class RoomService implements ServiceInterface
{
	private Map<Long,QuerableEntity> rooms;
	
	public RoomService()
	{
		rooms = new HashMap<Long,QuerableEntity>();
		rooms.put(1l, new Room());
	}
	
	@Override
	public List<QuerableEntity> query()
	{
		return new ArrayList<QuerableEntity>(rooms.values());
	}

	@Override
	public QuerableEntity get(long id)
	{
		return rooms.get(id);
	}
	
	@Override
	public void put(QuerableEntity querableEntity)
	{
		rooms.put(querableEntity.getId(), querableEntity);
	}
}
