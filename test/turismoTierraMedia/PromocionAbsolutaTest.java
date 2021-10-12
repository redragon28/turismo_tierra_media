package turismoTierraMedia;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import tpTierraMedia.Atraccion;
import tpTierraMedia.Promocion;
import tpTierraMedia.PromocionAbsoluta;
import tpTierraMedia.TipoAtraccion;

public class PromocionAbsolutaTest {

	@Test
	public void test() {
		
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		
		Promocion absoluta = new PromocionAbsoluta ("GetAll", 55, Atracciones);  
		
		assertNotNull(absoluta); 
	}

	
	@Test
	public void test2() {
		
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.AVENTURA);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		
		Promocion absoluta = new PromocionAbsoluta ("GetAll", 55, Atracciones);  
		
		assertEquals (55, absoluta.getPrecio (), 0.001);
	}
	
	@Test
	public void Testgetcupo() {
		
		List<Atraccion> Atracciones = new ArrayList<>();
		
		
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.AVENTURA);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 7, TipoAtraccion.AVENTURA);
		
		Atracciones.add(a1);
		Atracciones.add(a2);
		
		Promocion absoluta = new PromocionAbsoluta ("GetAll", 55, Atracciones);  
		
		assertEquals (5, absoluta.getCupo() , 0.001);
}
}