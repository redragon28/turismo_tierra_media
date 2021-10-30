package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionProvider;
import tpTierraMedia.Atraccion;
import tpTierraMedia.Itinerario;
import tpTierraMedia.Usuario;

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
	
	public List<Itinerario> findByIdUsuario(int id_usuario) throws SQLException {
		
		
		String query = "SELECT * FROM itinerarios "
				+ "WHERE itinerarios.id_usuario LIKE ? ";
		
		
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement statement = connection.prepareStatement(query);
		statement.setInt(1, id_usuario);
		ResultSet resultSet = statement.executeQuery();

		List<Itinerario> itinerario = new ArrayList<Itinerario>();
		while (resultSet.next()) {
			itinerario.add(toItinerario(resultSet));
		}
		return itinerario;

	}
	
	private Itinerario toItinerario(ResultSet resultSet) throws SQLException {

		Integer id_itinerario = Integer.valueOf(resultSet.getInt("id_itinerario"));
		Integer id_usuario = Integer.valueOf(resultSet.getInt("id_usuario"));
		Integer id_atraccion = Integer.valueOf(resultSet.getInt("id_atraccion"));
		Integer id_promocion = Integer.valueOf(resultSet.getInt("id_promocion"));
	

		Itinerario itinerario = new Itinerario(id_itinerario, id_usuario, id_atraccion, id_promocion);

		return itinerario;
	}


	@Override
	public List<Itinerario> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int update(Itinerario t) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(Itinerario itinerario) throws SQLException {
		String sqlQuery = "DELETE FROM itinerarios WHERE itinerarios.id_usuario LIKE ? ";
		
		Connection connection = ConnectionProvider.getConnection();
		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		statement.setInt(1, itinerario.getId_usuario());
		
		int rowsUpdate = statement.executeUpdate();

		return rowsUpdate;
	}


	@Override
	public Itinerario findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
