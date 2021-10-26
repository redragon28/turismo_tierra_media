package dao;

import java.sql.SQLException;

import tpTierraMedia.Usuario;

public interface UsuarioDao extends GenericDao<Usuario>{
	
	Usuario findByNombre(String nombre) throws SQLException;
}

