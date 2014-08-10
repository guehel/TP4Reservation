package reservation;

import java.sql.SQLException;

public class SingleServiceWeb {
	private static Services serviceReel;
	
public static Services getInstance(){
	if(serviceReel==null){
		try{serviceReel = new ServicesWeb();
		}catch(ClassNotFoundException| SQLException e){}
	}
	return serviceReel;
}
}
