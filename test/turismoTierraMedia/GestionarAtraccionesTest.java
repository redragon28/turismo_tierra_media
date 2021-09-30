package turismoTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tpTierraMedia.Atraccion;
import tpTierraMedia.GestionarAtracciones;
import tpTierraMedia.PromoPorcentual;
import tpTierraMedia.Promocion;
import tpTierraMedia.PromocionAbsoluta;
import tpTierraMedia.TipoAtraccion;
import tpTierraMedia.Usuario;

public class GestionarAtraccionesTest {

	@Test
	public void test() {
		
		List<Atraccion> Atracciones = new ArrayList<>();
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.PAISAJE);
		Atraccion a3 = new Atraccion ("Tfafasfasdas", 30, 2, 3, TipoAtraccion.PAISAJE);
		Atracciones.add(a1);
		Atracciones.add(a2);
		
		
		
		Promocion absoluta = new PromocionAbsoluta ("adasdas", 55, Atracciones);
		Usuario persona= new Usuario("joaquien", 50, 2, TipoAtraccion.DEGUSTACION);
		
		
		assertTrue(GestionarAtracciones.comparacion(a3, absoluta));
	}

}
