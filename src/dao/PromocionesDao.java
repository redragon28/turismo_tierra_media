package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.ConnectionProvider;
import tpTierraMedia.Promocion;
import tpTierraMedia.TipoAtraccion;
import tpTierraMedia.Usuario;

public class PromocionesDao implements GenericDao<>{
	
	public List<Promocion> findAll() throws SQLException {
		List<Promocion> promociones = new ArrayList<Promocion>();
		Connection connection = ConnectionProvider.getConnection();

		String query = "SELECT * FROM promocion";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			Promocion promocion = toPromocion(resultSet);
			promociones.add(promocion);
		}

		return promociones;
	}

	private Promocion toPromocion(ResultSet resultSet) throws SQLException {

		Integer idPromocion = resultSet.getInt("id_usuario");
		String nombre = resultSet.getString("nombre");
		Double presupuesto = resultSet.getDouble("monedas");
		Double tiempoDisponible = resultSet.getDouble("tiempo");
		//String tipoAtraccion = resultSet.getString("atraccion_preferida");
		TipoAtraccion tipoPreferido = TipoAtraccion.valueOf(resultSet.getString("preferencia"));

		Usuario promocion = new Promocion(idPromocion, nombre, presupuesto, tiempoDisponible, tipoPreferido);
		
		return promocion;
	}

}
