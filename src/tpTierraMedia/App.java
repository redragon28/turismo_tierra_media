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
		
		while( Consola.inicioApp().equals("SI")) {
			System.out.println("Eliga su usuario"+"\n");
			GestionarUsuarios.MostrarUsuarios(listaUsuarios);
			Usuario usuarioElegido = GestionarUsuarios.eleccionUsuario(Consola.leerIn(), listaUsuarios);
			Promocion promocionelegida = GestionarPromociones.eleccionPromocionPreferida(listaPromociones,usuarioElegido);
			Atraccion Atraccionelegida =GestionarAtracciones.elegirAtraccion(listaAtracciones, usuarioElegido, promocionelegida);   
		    ArmadoItinerario.armadoItinerario(promocionelegida, Atraccionelegida);
			
			
			
		 		
		}
		System.out.println("Lo esperamos en una proxima ocasion");
		System.out.println("");
		 
			
			
		
		 }
	}
}
	

