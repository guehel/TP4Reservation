package reservation.dao;

import com.mysql.jdbc.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import reservation.dto.ChambreDTO;
import reservation.dto.ReservationDTO;
import reservation.objects.Chambre;
import reservation.objects.Client;

public class ChambreDAO extends DAO<Chambre>{
	private ReservationDAO reservationDAO;
	public ChambreDAO(Connection connection) {
		super(connection);
		try {
			this.ajout = (PreparedStatement) connection.prepareStatement(
					"INSERT INTO `chambre`(`numero`) VALUES "
					+ "(?)"
					);
			this.miseAJour =  (PreparedStatement) connection.prepareStatement(
					"UPDATE `chambre` SET `numero`=? WHERE `numero`=?"
					);
			this.rechercher =  (PreparedStatement) connection.prepareStatement(
					"SELECT `numero` FROM `chambre`"
					+ "WHERE `numero`=? "
					);
			this.suppression =  (PreparedStatement) connection.prepareStatement(
					"DELETE FROM `chambre` WHERE `numero`=?"
					);
			reservationDAO = new ReservationDAO(connection);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public boolean create(Chambre chambre) {	
		ChambreDTO chamdreDto = new ChambreDTO(chambre);
		
		return createFromDTO(chamdreDto);
		
	}

	@Override
	public boolean delete(Chambre object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Chambre find(Chambre chambre) {
		
		return findByNumeroChambre(chambre.getNumeroChambre());
	}

	@Override
	public boolean update(Chambre object) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	public boolean createFromDTO(ChambreDTO chambre){
		 try {
				this.ajout.setInt(1, chambre.getNumeroChambre());
				for(ReservationDTO reservationDTO: chambre.getReservations() ){
					reservationDAO.saveFromDTO(reservationDTO);
				}
				int resultat = this.ajout.executeUpdate();
				return resultat == 1;
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		return false;
	}

	public ArrayList<Chambre> getAllChambres() {
		// TODO Auto-generated method stub
		return null;
	}

	public Chambre findByNumeroChambre(int int1) {
		Chambre chambre = null;
		try {

			this.rechercher.setInt( 1 , int1);
			
			ResultSet resultat = this.rechercher.executeQuery();
			if(resultat.next()){
			
				chambre = new Chambre();
				chambre.setNumeroChambre(resultat.getInt(1));
				
				
			}
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return chambre;
	
	}

}
