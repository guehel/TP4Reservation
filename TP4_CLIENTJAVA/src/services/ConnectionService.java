package services;

import java.util.Observable;

public class ConnectionService extends Observable
{
	private static ConnectionService instance;
	
	private ConnectionService(){}

	public static ConnectionService getInstance()
	{
		if (instance == null)
		{
			instance = new ConnectionService();
		}
		
		return instance;
	}

	public void connect(long employeId)
	{
		this.setChanged();
		this.notifyObservers(employeId);
	}
}
