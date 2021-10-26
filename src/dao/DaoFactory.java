package dao;

public class DAOFactory {

	public static UsuarioDao getUsuarioDao() {
		return new UsarioDaoImpl();
	}

	public static AtraccionesDao getAtraccionesDao() {
		return new AtraccionesDao();
	}
	public static PromocionesDao getPromocionesDao() {
		return new PromocionesDao();
	}
}