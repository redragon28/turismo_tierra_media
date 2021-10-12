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

	/*@Test
	public void MostrarAtraccionesPreferidas() {
		
		List<Atraccion> atracciones = new ArrayList<>();
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.PAISAJE);
		Atraccion a3 = new Atraccion ("jamaica", 30, 2, 3, TipoAtraccion.PAISAJE);
		Atraccion a4 = new Atraccion ("jamaica", 10 ,2 ,2, TipoAtraccion.PAISAJE);
		Atraccion a5 = new Atraccion ("Tigre", 1 ,2 ,2, TipoAtraccion.PAISAJE);
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		List<Atraccion> atracciones3 = new ArrayList<>();
		atracciones3.add(a1);
		atracciones3.add(a2);
		atracciones3.add(a3);
		
		
		Promocion absoluta = new PromocionAbsoluta ("rancho", 55, atracciones3);
		Promocion absoluta2 = new PromocionAbsoluta("paris", 30 , atracciones3);
		List <Promocion> promociones = new ArrayList<>();
		promociones.add(absoluta2);
		promociones.add(absoluta);
		Usuario persona= new Usuario("joaquien", 444, 44, TipoAtraccion.PAISAJE);
		
		List<Atraccion> atracciones2 = new ArrayList<>();
		atracciones2.add(a4);
		atracciones2.add(a5);
		assertEquals(atracciones2,GestionarAtracciones.mostrarAtraccionesPreferidas(atracciones,persona, promociones));
		//System.out.println(GestionarAtracciones.mostrarAtraccionesPreferidas(atracciones, persona, promociones));
		
	}*/
/*
	@Test
	public void test() {
		
		List<Atraccion> atracciones = new ArrayList<>();
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.PAISAJE);
		Atraccion a3 = new Atraccion ("finlandia", 30, 2, 3, TipoAtraccion.PAISAJE);
		Atraccion a4 = new Atraccion ("jamaica", 10 ,2 ,2, TipoAtraccion.PAISAJE);
		Atraccion a5 = new Atraccion ("NewYork", 1 ,2 ,2, TipoAtraccion.PAISAJE);
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		List<Atraccion> atracciones3 = new ArrayList<>();
		atracciones3.add(a1);
		atracciones3.add(a2);
		atracciones3.add(a3);
		
		
		Promocion absoluta = new PromocionAbsoluta ("rancho", 55, atracciones3);
		Promocion absoluta2 = new PromocionAbsoluta("paris", 30 , atracciones3);
		List <Promocion> promociones = new ArrayList<>();
		promociones.add(absoluta2);
		promociones.add(absoluta);
		Usuario persona= new Usuario("joaquien", 444, 44, TipoAtraccion.PAISAJE);
		
		List<Atraccion> atracciones2 = new ArrayList<>();
		atracciones2.add(a4);
		atracciones2.add(a5);
		assertEquals(atracciones2,GestionarAtracciones.mostrarAtraccionesPreferidas(atracciones,persona, promociones));
		//System.out.println(GestionarAtracciones.mostrarAtraccionesPreferidas(atracciones, persona, promociones));
		
	}*/
	@Test
public void condicionParaCOnseguirAlgunaAtraccion() {
		
		List<Atraccion> atracciones = new ArrayList<>();
		Atraccion a5 = new Atraccion ("salto", 35, 3, 5,TipoAtraccion.DEGUSTACION);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.DEGUSTACION);
		Atraccion a3 = new Atraccion ("Tigresafdsfds", 30, 2, 3, TipoAtraccion.DEGUSTACION);
		Atraccion a4 = new Atraccion ("salto", 10 ,2 ,2, TipoAtraccion.DEGUSTACION);
		Atraccion a1 = new Atraccion ("NewYork", 1 ,2 ,2, TipoAtraccion.DEGUSTACION);
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		
		List<Atraccion> atracciones3 = new ArrayList<>();
		atracciones3.add(a1);
		atracciones3.add(a2);
		atracciones3.add(a3);
		
		
		Promocion absoluta = new PromocionAbsoluta ("adasdas", 55, atracciones3);
		Promocion absoluta2 = new PromocionAbsoluta("sadasd", 30 , atracciones3);
		List <Promocion> promociones = new ArrayList<>();
		promociones.add(absoluta2);
		promociones.add(absoluta);
		
		Usuario persona= new Usuario("joaquien", 50, 20, TipoAtraccion.DEGUSTACION);
		
		
		assertTrue(GestionarAtracciones. condicionMinimaParaConseguirAtraccion(atracciones,persona , promociones));
}

	@Test
public void condicionParaCOnseguirAlgunaAtraccion2() {
		
		List<Atraccion> atracciones = new ArrayList<>();
		Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.DEGUSTACION);
		Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.DEGUSTACION);
		Atraccion a3 = new Atraccion ("Tigresafdsfds", 30, 2, 3, TipoAtraccion.DEGUSTACION);
		Atraccion a4 = new Atraccion ("salto", 10 ,2 ,2, TipoAtraccion.DEGUSTACION);
		Atraccion a5 = new Atraccion ("NewYork", 1 ,2 ,2, TipoAtraccion.PAISAJE);
		atracciones.add(a1);
		atracciones.add(a2);
		atracciones.add(a3);
		atracciones.add(a4);
		atracciones.add(a5);
		
		List<Atraccion> atracciones3 = new ArrayList<>();
		atracciones3.add(a1);
		atracciones3.add(a2);
		atracciones3.add(a3);
		
		
		Promocion absoluta = new PromocionAbsoluta ("adasdas", 55, atracciones3);
		Promocion absoluta2 = new PromocionAbsoluta("sadasd", 30 , atracciones3);
		List <Promocion> promociones = new ArrayList<>();
		promociones.add(absoluta2);
		promociones.add(absoluta);
		
		Usuario persona= new Usuario("joaquien", 50, 20, TipoAtraccion.DEGUSTACION);
		
		
		assertFalse(GestionarAtracciones. condicionMinimaParaConseguirAtraccion(atracciones,persona , promociones));
	}
		
		@Test
		public void condicionParaCOnseguirAlgunaAtraccion3() {
				
				List<Atraccion> atracciones = new ArrayList<>();
				Atraccion a1 = new Atraccion ("salto", 35, 3, 5,TipoAtraccion.DEGUSTACION);
				Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.DEGUSTACION);
				Atraccion a3 = new Atraccion ("Tigresafdsfds", 30, 2, 3, TipoAtraccion.DEGUSTACION);
				Atraccion a4 = new Atraccion ("salto", 10 ,2 ,2, TipoAtraccion.DEGUSTACION);
				Atraccion a5 = new Atraccion ("NewYork", 1 ,2 ,2, TipoAtraccion.DEGUSTACION);
				atracciones.add(a1);
				atracciones.add(a2);
				atracciones.add(a3);
				atracciones.add(a4);
				atracciones.add(a5);
				
				List<Atraccion> atracciones3 = new ArrayList<>();
				atracciones3.add(a1);
				atracciones3.add(a2);
				atracciones3.add(a3);
				
				
				Promocion absoluta = new PromocionAbsoluta ("adasdas", 55, atracciones3);
				Promocion absoluta2 = new PromocionAbsoluta("sadasd", 30 , atracciones3);
				List <Promocion> promociones = new ArrayList<>();
				promociones.add(absoluta2);
				promociones.add(absoluta);
				
				Usuario persona= new Usuario("joaquien", 50, 20, TipoAtraccion.DEGUSTACION);
				
				
				assertFalse(GestionarAtracciones. condicionMinimaParaConseguirAtraccion(atracciones,persona , promociones));
		}
				/*	@Test
public void ElegirAtraccion() {
	
	List<Atraccion> atracciones = new ArrayList<>();
	Atraccion a1 = new Atraccion ("salto", 35, 3, 5, TipoAtraccion.PAISAJE);
	Atraccion a2 = new Atraccion ("Tigre", 30, 2, 3, TipoAtraccion.PAISAJE);
	Atraccion a3 = new Atraccion ("finlandia", 30, 2, 3, TipoAtraccion.PAISAJE);
	Atraccion a4 = new Atraccion ("jamaica", 10 ,2 ,2, TipoAtraccion.PAISAJE);
	Atraccion a5 = new Atraccion ("NewYork", 1 ,2 ,2, TipoAtraccion.PAISAJE);
	atracciones.add(a1);
	atracciones.add(a2);
	atracciones.add(a3);
	atracciones.add(a4);
	atracciones.add(a5);
	List<Atraccion> atracciones3 = new ArrayList<>();
	atracciones3.add(a1);
	atracciones3.add(a2);
	atracciones3.add(a3);
	
	
	Promocion absoluta = new PromocionAbsoluta ("rancho", 55, atracciones3);
	Promocion absoluta2 = new PromocionAbsoluta("paris", 30 , atracciones3);
	List <Promocion> promociones = new ArrayList<>();
	promociones.add(absoluta2);
	promociones.add(absoluta);
	Usuario persona= new Usuario("joaquien", 444, 44, TipoAtraccion.PAISAJE);
	
	List<Atraccion> atracciones2 = new ArrayList<>();
	atracciones2.add(a4);
	atracciones2.add(a5);
	assertEquals(atracciones2,GestionarAtracciones.elegirAtraccion(atracciones,persona));
	//System.out.println(GestionarAtracciones.elegirAtraccion(atracciones,persona));
	
}*/
}
