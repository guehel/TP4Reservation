package services;

import java.util.List;

public interface ServiceInterface
{
	public List<QuerableEntity> query();
	
	public QuerableEntity get(long id);
	
	public void put(QuerableEntity querableEntity);
}
