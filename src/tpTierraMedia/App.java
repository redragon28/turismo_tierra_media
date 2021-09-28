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
			System.out.println("Escriba el nombre del usuario a elegir"+"\n");
			GestionarUsuarios.MostrarUsuarios(listaUsuarios);
			Usuario usuarioelegido = GestionarUsuarios.eleccionUsuario(Consola.leerIn(), listaUsuarios);
			Promocion promocionelegida = GestionarPromociones.eleccionPromocion(listaPromociones,usuarioelegido);
			Atraccion Atraccionelegida =GestionarAtracciones.elegirAtraccion(listaAtracciones, usuarioelegido, promocionelegida);   
			ArmadoItinerario.armadoItinerario(promocionelegida, Atraccionelegida);
			
			
			
		 		
		}
		System.out.println("Lo esperamos en una proxima ocasion");
		System.out.println("");
		 
			
			
		
		 }
	}
}
	

