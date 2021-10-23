package dao;

public class DAOFactory {

	public static UsarioDAO getUserDAO() {
		return new UserDAOImpl();
	}

	public static AtraccionesDAO getAtraccionesDAO() {
		return new AtraccionesDAO();
	}
	public static PromocionesDAO getPromocionesDAO() {
		return new PromocionesDAO();
	}
}