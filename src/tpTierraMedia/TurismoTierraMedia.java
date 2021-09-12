package tpTierraMedia;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TurismoTierraMedia {
	private static List<Atraccion> listaAtracciones;
	private static List<Promocion> listaPromociones;
	private static List<Usuario> listaUsuarios;
	
	public static void sugerirAtraccion(Usuario usuario) {
		
	}

	
	
	
	
	
	//Hay que ver como hacer la comparacion entre TipoPreferido del usuario con el tipoAtraccion
	public static List<Atraccion> sugerenciasAtraccionesPreferidas(Usuario usuario) {
		List<Atraccion> atraccionesRecomendadas = new ArrayList<Atraccion>();
		
		for (Atraccion atraccion : listaAtracciones) {
			if ((usuario.getTipoPreferido()).compareTo(atraccion.getTipo()) == 0) {
				if (atraccion.getCupoPersonas() > 0 && usuario.getPresupuesto() >= atraccion.getPrecio()
						&& usuario.getTiempoDisponible() >= atraccion.getDuracion()) {
					atraccionesRecomendadas.add(atraccion);
				}
			}
		}
		return atraccionesRecomendadas;
	}
	
	public static List<Promocion> sugerenciasPromociones(Usuario usuario) {
        List<Promocion> promocionesRecomendadas = new ArrayList<Promocion>();
        for (Promocion promocion : listaPromociones) {
			if (promocion.tipoPromocion() == 3 || promocion.tipoPromocion() == 2 || promocion.tipoPromocion() == 1)
	              promocionesRecomendadas.add(promocion);
        }
        return promocionesRecomendadas;
    }
	
	public static void ordenarAtraccionesPorPrecio(List<Atraccion> listaAtracciones) {
		Collections.sort(listaAtracciones, new PrecioComparator());
	}
	
	public static void ordenarAtraccionesPorDuracion(List<Atraccion> listaAtracciones) {
		Collections.sort(listaAtracciones, new DuracionComparator());
	}



}
