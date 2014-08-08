package reservation.dao;

import com.mysql.jdbc.Connection;

import java.sql.PreparedStatement;

public abstract class DAO<T> {
	protected Connection connection;
	protected PreparedStatement rechercher;
	protected PreparedStatement miseAJour;
	protected PreparedStatement suppression;
	protected PreparedStatement ajout;
	protected PreparedStatement rechercherTous;
	public DAO(Connection connection) {
		super();
		this.connection = connection;
	}
	public abstract boolean create(T object);
	public abstract boolean delete(T object);
	public abstract T find(T object);
	public abstract boolean update(T object);
}
