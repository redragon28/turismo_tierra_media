package turismoTierraMedia;

import static org.junit.Assert.*;
import org.junit.Test;

import tpTierraMedia.Atraccion;
import tpTierraMedia.PromoPorcentual;
import tpTierraMedia.Promocion;
import tpTierraMedia.TipoAtraccion;

import java.util.ArrayList;
import java.util.List;


public class PromocionPorcentualTest {

	
		@Test
		public void test() {
			
			List<Atraccion> Atracciones = new ArrayList<>();
			
			
			Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
			Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
			
			Atracciones.add(a1);
			Atracciones.add(a2);
			
			Promocion flex = new PromoPorcentual ("Relax", 20, Atracciones);  
			
			assertNotNull(flex); 
		}

		
		@Test
		public void test2() {
			
			List<Atraccion> Atracciones = new ArrayList<>();
			
			
			Atraccion a1 = new Atraccion ("Salto", 35, 3, 5, TipoAtraccion.PAISAJE);
			Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.PAISAJE);
			
			Atracciones.add(a1);
			Atracciones.add(a2);
			
			Promocion flex = new PromoPorcentual ("Relax", 0.2, Atracciones);  
			
			assertEquals (52, flex.getPrecio (), 0.001);
			
			assertEquals (5, flex.getTiempoPromocion(), 0.001);
			
			assertEquals (TipoAtraccion.PAISAJE, flex.getPreferenciaPromo ());
		}

	}
