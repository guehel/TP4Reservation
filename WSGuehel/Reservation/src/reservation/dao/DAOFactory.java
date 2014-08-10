package reservation.dao;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

import reservation.FacadeServiceWeb;



public class DAOFactory {
	public enum Table{
		RESERVATION, CLIENT, CHAMBRE;
	}

	private  String url="jdbc:mysql://localhost:3306/tp4_reservation";

	private   String user ="root";
	private   String password ="Vlvy7410";
//	password ="";
	private Connection connection;
	public DAOFactory() throws ClassNotFoundException, SQLException  {
//		url="jdbc:mysql://192.168.2.14:3306/commandes";
//		String user ="guehel";
//		password ="test";
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url,user,password);
	}
	
	
	public DAO<?> getDAO(Table table ){
		DAO<?> dao = null;
		if (connection!=null) {
			switch (table) {
			case RESERVATION:
				dao = new ReservationDAO(connection);
				break;
			case CLIENT:
				dao = new ClientDAO(connection);
				break;
			case CHAMBRE:
				dao = new ChambreDAO(connection);
				break;
			
			default:
				break;
			}
		}
		return dao;
	}
	
	@Override
	protected void finalize() throws Throwable {
		this.connection.close();
		super.finalize();
	}
	
	public static void main(String [] args){
		try {
			
			DAOFactory da = new DAOFactory();
			da.getDAO(Table.RESERVATION);
			FacadeServiceWeb facade = new FacadeServiceWeb();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
