package reservation;



public class SingleServiceWeb {
	private static Services serviceReel;
	
public static Services getInstance(){
	if(serviceReel==null){
		serviceReel = new ServicesWeb();
	
	}
	return serviceReel;
}
}
