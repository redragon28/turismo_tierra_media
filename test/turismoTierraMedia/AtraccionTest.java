package turismoTierraMedia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;

import tpTierraMedia.Atraccion;
import tpTierraMedia.TipoAtraccion;

public class AtraccionTest {
	
	Atraccion atr = new Atraccion("Bosque negro", 3.0, 4, 12, TipoAtraccion.AVENTURA);

	@Test
	public void notNull() {
		Assert.assertNotNull(atr);
	}
	
	@Test
	public void gettersTest() {
		String nombre = "Bosque negro";
		double precio = 3;
		double duracion = 4;
		int cupo = 12;
		TipoAtraccion aventura = TipoAtraccion.AVENTURA;

		Assert.assertTrue(nombre == atr.getNombre());
		Assert.assertTrue(precio == atr.getPrecio());
		Assert.assertTrue(duracion == atr.getDuracion());
		Assert.assertTrue(cupo == atr.getCupoPersonas());
		Assert.assertTrue(aventura == atr.getTipo());
	}
	@Test
	public void listaTipoAtraccionTest() {
		List<TipoAtraccion> list = new ArrayList<TipoAtraccion>();
		list.add(atr.getTipo());
		Assert.assertEquals(list, atr.getListaTiposAtraccion());
	}
}


