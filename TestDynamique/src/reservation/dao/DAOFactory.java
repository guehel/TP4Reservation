package reservation.dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import reservation.dao.ChambreDAO;
import reservation.dao.ClientDAO;
import reservation.dao.DAO;

import com.mysql.jdbc.Connection;

public class DAOFactory {
	public enum Table {
		RESERVATION, CLIENT, CHAMBRE;
	}

	private String url = "jdbc:mysql://localhost:3306/";
	private String bd = "tp4_reservation";
	private String user = "root";
	private String password = "root";
	private Connection connection;

	public DAOFactory() throws ClassNotFoundException, SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = (Connection) DriverManager.getConnection(url + bd,
					user, password);
		} catch (ClassNotFoundException | SQLException e) {
			Scanner sc = new Scanner(System.in);
			System.out
					.println("Les parametre ne semplent pas marcher\n\tDonner:");
			System.out.println("nom de la base de donne");
			bd = sc.next().trim();
			System.out.println("le compte admin ");
			user = sc.next().trim();
			System.out.println("le mot de passe");
			password = sc.next().trim();
			connection = (Connection) DriverManager.getConnection(url + bd,
					user, password);
		}
	}

	public DAO<?> getDAO(Table table) {
		DAO<?> dao = null;
		if (connection != null) {
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

}
