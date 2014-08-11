package reservation.dao;

import com.mysql.jdbc.Connection;





import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;
import reservation.dto.ClientDTO;

import reservation.objects.Client;

public class ClientDAO extends DAO<Client>{
	


	public ClientDAO(Connection connection) {
		super(connection);
		try {
			this.ajout =  (PreparedStatement) connection.prepareStatement(
					"INSERT INTO `client`(`id`, `nom`, `prenom`) "
					+ "VALUES (?, ?, ?)"
					);
			this.miseAJour =  (PreparedStatement) connection.prepareStatement(
					"UPDATE `client` SET `nom`=?,`prenom`=? WHERE `id`=?"
					);
			this.rechercher =  (PreparedStatement) connection.prepareStatement(
					"SELECT `id`, `nom`, `prenom` FROM `client` WHERE `id` = ? "
					);
			this.rechercherTous =  (PreparedStatement) connection.prepareStatement(
					"SELECT `id`, `nom`, `prenom` FROM `client`"
				
					);
			this.suppression =  (PreparedStatement) connection.prepareStatement(
					"DELETE FROM `client` WHERE `id`=?"
					);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Client client) {
		ClientDTO clientDTO = new ClientDTO(client);
		return createFromDTO(clientDTO);
	}

	@Override
	public boolean delete(Client client) {
		try {
			
			
			this.suppression.setInt(1, client.getIdClient());
			int resultat = this.suppression.executeUpdate();
			return resultat == 1;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Client find(Client client) {
		ClientDTO clientDTO = new ClientDTO(client);
		return findById(clientDTO.getId());
	}

	@Override
	public boolean update(Client object) {
	try {
			
			this.miseAJour.setInt(3, object.getIdClient());
			this.miseAJour.setString(1, object.getNom());
			this.miseAJour.setString(2, object.getPrenom());
			
			int resultat = this.miseAJour.executeUpdate();
			return resultat == 1;
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return false;
	}
	
	public ClientDTO createDTO(Client client){
		return null;
	}
	
	public boolean createFromDTO(ClientDTO clientDTO){
		try{
			this.ajout.setInt(1, clientDTO.getId());
			this.ajout.setString(2, clientDTO.getNom());
			this.ajout.setString(3, clientDTO.getPrenom());
		int resultat = this.ajout.executeUpdate();
		return resultat == 1;
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return false;
	}

	public Client findById(int int1) {
		Client client = null;
		try {

			this.rechercher.setInt( 1 , int1);
			
			ResultSet resultat = this.rechercher.executeQuery();
			resultat.toString();
			if(resultat.next()){
				client = getClientFromResultSet(resultat);
								
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return client;
	}

	public ArrayList<Client> getAllClients() {
		ArrayList<Client> clients = new ArrayList<Client>();
		
		Client client = null;
		try {
		
			 ResultSet resultat = this.rechercherTous.executeQuery();
			while(resultat.next()){
				
				client = getClientFromResultSet(resultat);
				clients.add(client);

			}

		} catch (SQLException e) {	

			e.printStackTrace();
		}
		
		return clients;
	}

	private Client getClientFromResultSet(ResultSet resultat) throws SQLException {
		Client client  = new Client();
		client.setIdClient(resultat.getInt(1));
		client.setNom(resultat.getString(2));
		client.setPrenom(resultat.getString(3));
		
		return client;
	
	}

}
