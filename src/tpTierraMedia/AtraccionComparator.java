package tpTierraMedia;

import java.util.Comparator;

public class AtraccionComparator implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion atraccion1, Atraccion atraccion2) {

		int comparacion = 0;

		if (atraccion1.getPrecio() > atraccion2.getPrecio()) {
			if(atraccion1.getDuracion() >= atraccion2.getDuracion()) {
				comparacion = -1;
			}else if(atraccion1.getDuracion() < atraccion2.getDuracion()) {
				comparacion = 1;
			}
		
		}else if(atraccion1.getPrecio() < atraccion2.getPrecio()) {
			if(atraccion1.getDuracion() > atraccion2.getDuracion()) {
				comparacion = -1;
			}else if(atraccion1.getDuracion() <= atraccion2.getDuracion()) {
				comparacion = 1;
			}
		}
			return comparacion;   
				
	}

}