package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionProvider;
import tpTierraMedia.Atraccion;
import tpTierraMedia.TipoAtraccion;

public class AtraccionesDao {

	public List<Atraccion> findAll() throws SQLException {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT * FROM Atracciones";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Atraccion atracciones = toAtraccion(resultSet);
			atracciones.add(atraccion);
		}

		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet resultSet) throws SQLException {

		Integer id = resultSet.getInt("id_atraccion");
		String nombre = resultSet.getString("nombre");
		Double precio = resultSet.getDouble("monedas");
		Double duracion = resultSet.getDouble("tiempo");
		Integer cupoPersonas = resultSet.getInt("cupo");
		String tipoAtraccion = resultSet.getString("tipo_atraccion");

		Atraccion atraccion = new Atraccion(id, nombre, precio, duracion, cupoPersonas, tipoAtraccion);

		return atraccion;
	}

	public int insert(Atraccion atraccion) throws SQLException {
		String sqlQuery = "INSERT INTO Atraccion (id_atraccion,nombre,monedas,tiempo,cupo,tipo_atraccion) "
				+ "VALUES (?,?,?,?,?,?)";
		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, atraccion.getId());
		statement.setString(2, atraccion.getNombre());
		statement.setDouble(3, atraccion.getPrecio());
		statement.setDouble(4, atraccion.getDuracion());
		statement.setString(5, atraccion.getTipo());
		// Hay que pasarlo a TipoAtraccion

		int rowsUpdated = statement.executeUpdate();

		return rowsUpdated;
	}

	public int delete(Atraccion atraccion) throws SQLException {
		return delete(atraccion.getId());
	}

	public int delete(Integer id) throws SQLException {
		String sqlDeleteQuery = "DELETE FROM Atraccion WHERE id=?";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery);
		statement.setInt(1, id);

		int rowsUpdated = statement.executeUpdate();
		return rowsUpdated;
	}

	public int update(Atraccion atraccion) throws SQLException {
		String sqlQuery = "UPDATE atraccion" + "WHERE id = ?" + "SET nombre = ?, " + "presupuesto = ?, " + "tiempo = ?,"
				+ "atraccion_preferida = ?";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, atraccion.getId());
		statement.setString(2, atraccion.getNombre());
		statement.setDouble(3, atraccion.getPrecio());
		statement.setDouble(4, atraccion.getDuracion());
		statement.setString(5, atraccion.getTipo());

		int rowsUpdate = statement.executeUpdate();

		return rowsUpdate;
	}

	public int countAll(Atraccion atraccion) throws SQLException {
		String sqlQuery = "SELECT COUNT() AS total FROM Atraccion";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		int total = resultSet.getInt("total");

		return total;

	}
}
