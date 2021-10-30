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

		String query = "SELECT * "
				+ "FROM atracciones "
				+ "JOIN tipo_atraccion ON tipo_atraccion.id_tipo = atracciones.tipo ";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Atraccion atraccion = toAtraccion(resultSet);
			atracciones.add(atraccion);
		}

		return atracciones;
	}

	private Atraccion toAtraccion(ResultSet resultSet) throws SQLException {

		Integer idAtraccion = resultSet.getInt("id_atraccion");
		String nombre = resultSet.getString("nombre");
		Double precio = resultSet.getDouble("costo");
		Double duracion = resultSet.getDouble("tiempo");
		Integer cupoPersonas = resultSet.getInt("cupo");
		TipoAtraccion tipo = TipoAtraccion.valueOf(resultSet.getString("tipo"));

		Atraccion atraccion = new Atraccion(idAtraccion, nombre, precio, duracion, cupoPersonas, tipo);

		return atraccion;
	}
	
	public List<Atraccion> findByName(String nombre) throws SQLException {
		List<Atraccion> atracciones = new ArrayList<Atraccion>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT * "
				+ "FROM atracciones "
				+ "JOIN tipo_atraccion ON tipo_atraccion.id_tipo = atracciones.tipo "
				+ "WHERE atracciones.nombre LIKE ? ";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, nombre);
		ResultSet resultSet = statement.executeQuery();

		while (resultSet.next()) {
			Atraccion atraccion = toAtraccion(resultSet);
			atracciones.add(atraccion);
		}

		return atracciones;
	}

	public int insert(Atraccion atraccion) throws SQLException {
		String sqlQuery = "INSERT INTO atracciones (nombre,costo,tiempo,cupo,tipo) "
				+ "VALUES (?,?,?,?,?)";
		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		
		statement.setString(1, atraccion.getNombre());
		statement.setDouble(2, atraccion.getPrecio());
		statement.setDouble(3, atraccion.getDuracion());
		statement.setInt(4, atraccion.getCupoPersonas());
		statement.setInt(5, atraccion.getTipo().ordinal() + 1);
		
		int rowsUpdated = statement.executeUpdate();

		return rowsUpdated;
	}


	public int delete(Atraccion atraccion) throws SQLException {
		String sqlDeleteQuery = "DELETE FROM atracciones WHERE atracciones.nombre LIKE ? ";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery);
		statement.setString(1, atraccion.getNombre());

		int rowsUpdated = statement.executeUpdate();
		return rowsUpdated;
	}

	public int update(Atraccion atraccion) throws SQLException {
		String sqlQuery = "UPDATE atraccion" + "WHERE id = ?" + "SET nombre = ?, " + "presupuesto = ?, " + "tiempo = ?,"
				+ "atraccion_preferida = ?";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setString(1, atraccion.getNombre());
		statement.setDouble(2, atraccion.getPrecio());
		statement.setDouble(3, atraccion.getDuracion());
		statement.setInt(4, atraccion.getCupoPersonas());
		statement.setInt(5, atraccion.getTipo().ordinal() + 1);

		int rowsUpdate = statement.executeUpdate();

		return rowsUpdate;
	}

	public int countAll() throws SQLException {
		String sqlQuery = "SELECT COUNT() AS total "
				+ "FROM atracciones ";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		int total = resultSet.getInt("total");

		return total;

	}
}
