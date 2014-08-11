package Test;

import java.sql.SQLException;

import reservation.ServicesWeb;

public class essa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ServicesWeb s;
		try {
			s = new        ServicesWeb();
			System.out.println(s.obtenirListeClients().length);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
