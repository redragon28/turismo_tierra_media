package tpTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PromocionTest {

	@Test
	public void test() {
		
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		
		Promocion ema = new PromoPorcentual ("ema", 20, Atracciones);  
		
		assertNotNull(ema); 
	}

	
	@Test
	public void test2() {
		
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("Salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.PAISAJE);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		
		Promocion ema = new PromoPorcentual ("ema", 0.2, Atracciones);  
		
		assertEquals (52, ema.getPrecio (), 0.001);
		
		assertEquals (5, ema.getTiempoPromocion(), 0.001);
		
		assertEquals (TipoAtraccion.PAISAJE, ema.getPreferenciaPromo ());
	}

}
