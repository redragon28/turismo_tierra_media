package tpTierraMedia;

import java.util.List;

public class App {
	
	public static void crearItinerario(Promocion PromocionPreferida , Atraccion preferida) {
		
	}
	
	public static void main(String[] args) {
		
	    int i= 0;
	    
		while (i ==0) {
	    
		Consola.metodoSaludar();
		List<Atraccion>listaAtracciones = GestionarAtracciones.readAtraccionesFileAndCreateList();
		List<Promocion>listaPromociones = GestionarPromociones.readPromocionFileAndCreateList();
		List<Usuario> listaUsuarios=GestionarUsuarios.readUsuariosFileAndCreateList();
		
				
		while( Consola.inicioApp().equals("SI")  && !listaUsuarios.isEmpty())  {
		List<Promocion>listaPromocionesModificables =listaPromociones;
		List<Atraccion>listaAtraccionesModificables =listaAtracciones;
		GestionarUsuarios.MostrarUsuarios(listaUsuarios);
		Usuario usuarioelegido = GestionarUsuarios.eleccionUsuario( listaUsuarios);
		
		
		List<Promocion> promocionesElegidas = GestionarPromociones.eleccionesPromociones(listaPromocionesModificables,usuarioelegido);
		listaUsuarios.remove(usuarioelegido);
		
		List<Atraccion> atraccionElegida= GestionarAtracciones.guardadoAtraccionesElegidas(listaAtraccionesModificables, usuarioelegido, promocionesElegidas);
		ImpresionItinerario.generarArchivo(usuarioelegido,promocionesElegidas, atraccionElegida);
			
			
			
		Consola.metodoSaludar();	
		}
		System.out.println("Se reinicio la aplicacion");
		System.out.println("");
		
			
			
		
		 }
	}
}
	

