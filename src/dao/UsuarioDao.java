package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionProvider;
import tpTierraMedia.TipoAtraccion;
import tpTierraMedia.Usuario;

public class UsuarioDao implements GenericDao<Usuario> {

	public Usuario findByName(String nombre) throws SQLException {
		Usuario usuario = null;

		Connection connection = ConnectionProvider.getConnection();
		String query = "SELECT * FROM Usuario WHERE nombre=?";

		PreparedStatement statement = connection.prepareStatement(query);
		statement.setString(1, nombre);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			usuario = toUsuario(resultSet);
		}
		return usuario;

	}

	public List<Usuario> findAll() throws SQLException {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT * FROM Usuario";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Usuario usuario = toUsuario(resultSet);
			usuarios.add(usuario);
		}

		return usuarios;
	}

	private Usuario toUsuario(ResultSet resultSet) throws SQLException {

		Integer idUsuario = resultSet.getInt("id_usuario");
		String nombre = resultSet.getString("nombre");
		Double presupuesto = resultSet.getDouble("monedas");
		Double tiempoDisponible = resultSet.getDouble("tiempo");
		//String tipoAtraccion = resultSet.getString("atraccion_preferida");
		TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(resultSet.getString("preferencia"));

		Usuario usuario = new Usuario(idUsuario, nombre, presupuesto, tiempoDisponible, tipoPreferido);
		// Habria que cambiar el constructor de Usuario y ver los nombres de las tablas
		// de SQL de usuario
		return usuario;
	}

	public int insert(Usuario usuario) throws SQLException {
		String sqlQuery = "INSERT INTO Usuario (nombre,monedas,tiempo,preferencia) "
				+ "VALUES (?,?,?,?)";
		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setString(1, usuario.getNombre());
		statement.setDouble(2, usuario.getPresupuesto());
		statement.setDouble(3, usuario.getTiempoDisponible());
		statement.setInt(4, usuario.getTipoPreferido().ordinal() + 1);
		//lo de ordinal lo pusimos para que de el orden de los enum. En las tabla en vez de poner text, seria un int.

		int rowsUpdated = statement.executeUpdate();

		return rowsUpdated;
	}

	public int delete(Usuario usuario) throws SQLException {
		return delete(usuario.getIdUsuario());
	}

	public int delete(Integer id) throws SQLException {
		String sqlDeleteQuery = "DELETE FROM Usuario WHERE id=?";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery);
		statement.setInt(1, id);

		int rowsUpdated = statement.executeUpdate();
		return rowsUpdated;
	}

	public int update(Usuario usuario) throws SQLException {
		String sqlQuery = "UPDATE usuario" + "WHERE id = ?" + "SET nombre = ?, " + "presupuesto = ?, " + "tiempo = ?,"
				+ "atraccion_preferida = ?";
		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);

		statement.setInt(1, usuario.getIdUsuario());
		statement.setString(2, usuario.getNombre());
		statement.setDouble(3, usuario.getPresupuesto());
		statement.setDouble(4, usuario.getTiempoDisponible());
		statement.setInt(4, usuario.getTipoPreferido().ordinal() + 1);

		int rowsUpdate = statement.executeUpdate();

		return rowsUpdate;
	}

	public int countAll(Usuario usuario) throws SQLException {
		String sqlQuery = "SELECT COUNT() AS total FROM usuarios";

		Connection connection = ConnectionProvider.getConnection();

		PreparedStatement statement = connection.prepareStatement(sqlQuery);
		ResultSet resultSet = statement.executeQuery();
		resultSet.next();
		int total = resultSet.getInt("total");

		return total;

	}

	@Override
	public int countAll() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Usuario findById(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
