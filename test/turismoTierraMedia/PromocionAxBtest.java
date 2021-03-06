package turismoTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tpTierraMedia.Atraccion;
import tpTierraMedia.Promocion;
import tpTierraMedia.TipoAtraccion;
import tpTierraMedia.PromocionAxB;

public class PromocionAxBtest {

	@Test
	public void test() {
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("Salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion ("Aconcagua", 20, 3, 5, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		Atracciones.add(a3);
		
		Promocion dosXuno = new PromocionAxB ("Escapada", Atracciones);  
		
		assertNotNull(dosXuno); 
	}

	
	@Test
	public void test2() {
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("Salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion ("Aconcagua", 20, 3, 5, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		Atracciones.add(a3);
		
		Promocion dosXuno = new PromocionAxB ("Escapada", Atracciones);  
		
		assertEquals(65, dosXuno.getPrecio(), 0.001); 
	}
	

	@Test
	public void test3() {
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("Salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
		Atraccion a3 = new Atraccion ("Aconcagua", 20, 3, 5, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		Atracciones.add(a3);
		
		PromocionAxB dosXuno = new PromocionAxB ("Escapada", Atracciones);  
		
		 
		assertEquals ("Aconcagua", dosXuno.visitaGratis ());
	}
	
	
	
	
}