package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.ConnectionProvider;
import tpTierraMedia.Atraccion;

public class ItinerarioDao implements GenericDao<Itinerario> {

	public int insert(Itinerario itinerario) throws SQLException {
		String sqlQuery = "INSERT INTO itinerarios (id_usuario, id_atraccion, id_promocion) "
				+ "VALUES (?, ?, ?)";
		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, itinerario.getId_usuario());
		statement.setInt(2, itinerario.getId_atraccion());
		statement.setInt(3, itenerario.getId_promocion());
	
	

		int rowsUpdated = statement.executeUpdate();

		return rowsUpdated;
	}
	
	
	private Itinerario toItinerario(ResultSet resultSet) throws SQLException {

		Integer id_itinerario = Integer.valueOf(resultSet.getInt("id_itinerario"));
		Integer id_usuario = Integer.valueOf(resultSet.getInt("id_usuario"));
		Integer id_atraccion = Integer.valueOf(resultSet.getInt("id_atraccion"));
		Integer id_promocion = Integer.valueOf(resultSet.getInt("id_promocion"));
	

		Itinerario itinerario = new Itinerario(id_itinerario, id_usuario, id_atraccion, id_promocion);

		return itinerario;
	}

	
}
