package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionProvider;
import tpTierraMedia.Usuario;


public class UsarioDaoImpl implements UsuarioDao {

		public Usuario findByName(String nombre) throws SQLException {
			Usuario usuario = null;

			Connection connection = ConnectionProvider.getConnection();
			String query = "select * from Farmacia where nombre=?";
				
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

			String query = "select * from Farmacia";

			PreparedStatement preparedStatement = connection.prepareStatement(query);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Usuario usuario = toUsuario(resultSet);
				usuarios.add(usuario);
			}

			return usuarios;
}

		
		private Usuario toUsuario(ResultSet resultSet) throws SQLException {

			Integer id = resultSet.getInt("id_usuario");
			String nombre = resultSet.getString("nombre");
			Double presupuesto = resultSet.getDouble("monedas");
			Double tiempoDisponible = resultSet.getDouble("tiempo");
			String tipoAtraccion = resultSet.getString("atraccion_preferida");
			
			Usuario usuario = new Usuario(id, nombre, presupuesto, tiempoDisponible, tipoAtraccion);
		//Habria que cambiar el constructor de Usuario y ver los nombres de las tablas de SQL de usuario
			return usuario;
		}
		
		public int insert(Usuario usuario) throws SQLException {
			String sqlQuery = "INSERT INTO Usuario (id_usuario,nombre,monedas,tiempo,atraccion_preferida) " 
						+ "VALUES (?,?,?,?,?,?)";
			Connection connection = ConnectionProvider.getConnection();

			PreparedStatement statement = connection.prepareStatement(sqlQuery);

			statement.setInt(1, usuario.getId());
			statement.setString(2, usuario.getNombre());
			statement.setDouble(3, usuario.getPresupuesto());
			statement.setDouble(4, usuario.getTiempoDisponible());
			statement.setString(5, usuario.getTipoPreferido());
		//Hay que pasarlo a TipoAtraccion

			int rowsUpdated = statement.executeUpdate();

			return rowsUpdated;
		}
		
		public int delete(Usuario usuario) throws SQLException {
			return delete(usuario.getId());
		}
		
		public int delete(Integer id) throws SQLException {
			String sqlDeleteQuery = "DELETE FROM Usuario WHERE id=?";
			
			Connection connection = ConnectionProvider.getConnection();
			
			PreparedStatement statement = connection.prepareStatement(sqlDeleteQuery);
			statement.setInt(1, id);

			int rowsUpdated = statement.executeUpdate();
			return rowsUpdated;
		}
}
