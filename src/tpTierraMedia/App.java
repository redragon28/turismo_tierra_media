package tpTierraMedia;

import java.util.List;

public class App {
	
	public static void crearItinerario(Promocion PromocionPreferida , Atraccion preferida) {
		
	}
	
	public static void main(String[] args) {
		// bienvenido a bla bla(salida)
		List<Usuario> listaUsuarios=GestionarUsuarios.readUsuariosFileAndCreateList();
		List<Atraccion>listaAtracciones = GestionarAtracciones.readAtraccionesFileAndCreateList();
		List<Promocion>listaPromociones = GestionarPromociones.readPromocionFileAndCreateList();
		
	    int i= 0;
	    
		while (i ==0) {
	    
		Consola.metodoSaludar();
		
		while( Consola.inicioApp().equals("SI")  && !listaUsuarios.isEmpty())  {
			
		GestionarUsuarios.MostrarUsuarios(listaUsuarios);
		Usuario usuarioelegido = GestionarUsuarios.eleccionUsuario( listaUsuarios);
		Promocion promocionelegida = GestionarPromociones.eleccionPromocion(listaPromociones,usuarioelegido);
		
			listaUsuarios.remove(usuarioelegido);
			//Atraccion Atraccionelegida =GestionarAtracciones.elegirAtraccion(listaAtracciones, usuarioelegido, promocionelegida); 
			 List<Atraccion> atraccionElegida= GestionarAtracciones.guardadoAtraccionesElegidas(listaAtracciones, usuarioelegido, promocionelegida);
			  System.out.println(" estas son tus elecciones"+ ArmadoItinerario.armadoItinerario(promocionelegida, atraccionElegida));
			
			
			
		 		
		}
		System.out.println("Lo esperamos en una proxima ocasion");
		System.out.println("");
		 
			
			
		
		 }
	}
}
	

