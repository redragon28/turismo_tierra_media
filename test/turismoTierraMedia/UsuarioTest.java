package turismoTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import tpTierraMedia.TipoAtraccion;
import tpTierraMedia.Usuario;

public class UsuarioTest {

	Usuario usuario = new Usuario("Gandalf", 100, 5, TipoAtraccion.PAISAJE);

	@Test
	public void EsBuenPrecioTest() {

		double precio = usuario.presupuesto - 100;

		Assert.assertTrue(usuario.esBuenPrecio(precio));

	}
	
	@Test
	public void EsBuenPrecioTest2() {  // Devulve falso porque no es buen precio, ya que el precio es mayor que el presupuesto

		double precio = usuario.presupuesto + 100;

		Assert.assertFalse(usuario.esBuenPrecio(precio));

	}

	@Test
	public void EsTiempoSuficienteTest() {
		double duracion = usuario.tiempoDisponible - 4;

		Assert.assertTrue(usuario.esTiempoSuficiente(duracion));
	}
	
	@Test
	public void EsTiempoSuficienteTest2() {  // Devuelve falso porque la duracion es mayor que el tiempo disponible
		double duracion = usuario.tiempoDisponible + 2.5;

		Assert.assertFalse(usuario.esTiempoSuficiente(duracion));
	}
	
	
	@Test
	public void EsAtraccionPreferidaTest() {
		List<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		tiposAtraccion.add(TipoAtraccion.AVENTURA);
		tiposAtraccion.add(TipoAtraccion.PAISAJE);

		Assert.assertTrue(usuario.esAtraccionPreferida(tiposAtraccion));
	}
	
	@Test
	public void EsAtraccionPreferidaTest2() { // la atracción preferida no está dentro de la lista
		List<TipoAtraccion> tiposAtraccion = new ArrayList<TipoAtraccion>();
		tiposAtraccion.add(TipoAtraccion.AVENTURA);
		tiposAtraccion.add(TipoAtraccion.DEGUSTACION);

		Assert.assertFalse(usuario.esAtraccionPreferida(tiposAtraccion));
	}
}
