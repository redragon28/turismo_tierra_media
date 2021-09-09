package tpTierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TurismoTierraMedia {
	
	
	public static void sugerirAtraccion(Usuario usuario) {
		
	}

	
	
	
	
	
	//Hay que ver como hacer la comparacion entre TipoPreferido del usuario con el tipoAtraccion
	public static List<Atraccion> sugerenciasAtraccionesPreferidas(Usuario usuario) {
		List<Atraccion> atraccionesRecomendadas = new ArrayList<Atraccion>();
		
		for (Atraccion atraccion : listaAtracciones) {
			if ((usuario.getTipoPreferido()).comparteTo(atraccion.getTipo()) == 0) {
				if (atraccion.getCupoPersonas() > 0 && usuario.getPresupuesto() >= atraccion.getPrecio()
						&& usuario.getTiempoDisponible() >= atraccion.getDuracion()) {
					atraccionesRecomendadas.add(atraccion);
				}
			}
		}
		return atraccionesRecomendadas;
	}
	
	public static void ordenarAtraccionesPorPrecio(List<Atraccion> listaAtracciones) {
		Collections.sort(listaAtracciones, new PrecioComparator());
	}
	
	public static void ordenarAtraccionesPorDuracion(List<Atraccion> listaAtracciones) {
		Collections.sort(listaAtracciones, new DuracionComparator());
	}



}
