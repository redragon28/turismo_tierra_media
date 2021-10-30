package turismoTierraMedia;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dao.DaoFactory;
import dao.UsuarioDao;
import tpTierraMedia.Atraccion;
import tpTierraMedia.Promocion;
import tpTierraMedia.TipoAtraccion;

import tpTierraMedia.Usuario;

public class TurismoTierraMediaTest {

	/*TurismoTierraMedia ttm = new TurismoTierraMedia();

	Usuario user1 = new Usuario("Pedro", 1000, 1000, TipoAtraccion.AVENTURA);

	Atraccion atr1 = new Atraccion("Atraccion1", 10, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr2 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr3 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr4 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);
	Atraccion atr5 = new Atraccion("Atraccion2", 11, 2, 10, TipoAtraccion.AVENTURA);

	ArrayList<Atraccion> Atracciones = new ArrayList<Atraccion>();
	ArrayList<Promocion> Promociones = new ArrayList<Promocion>();

	@Test
	public void generarArchivoTest() {

		Atracciones.add(atr1);
		Atracciones.add(atr2);
		Atracciones.add(atr3);
		Atracciones.add(atr4);
		Atracciones.add(atr5);
		// esto solo funciona si cambiamos atraccionesAdquiridas y promocionesAdquiridas
		// a public pero lo hice para ahorrar tiempo
		// user1.atraccionesAdquiridas= Atracciones;
		// user1.promocionesAdquiridas= Promociones;
		ttm.generarArchivo(user1);
		// no hace nada pero era solo para probar que crea el archivo en la ruta
		// especifica.
	}
*/
	
	@Test
	public void findAllUsuarioTest() throws SQLException {
		UsuarioDao userConn = DaoFactory.getUsuarioDao();

		List<Usuario> usuarios = userConn.findAll();

		assertEquals("Eowyn", usuarios.get(0).getNombre());
		assertEquals("Gandalf", usuarios.get(1).getNombre());
		/*assertEquals("Sebastian", usuarios.get(2).getNombreDeUsuario());
		assertEquals("Jeremias", usuarios.get(3).getNombreDeUsuario());
		assertEquals("Tomas", usuarios.get(4).getNombreDeUsuario());
		assertEquals("Diego", usuarios.get(5).getNombreDeUsuario());
*/
		// Imprime todos los usuarios
		for (Usuario usuario : usuarios)
			System.out.println(usuario.getNombre());

	}
}
