package tpTierraMedia;

import java.util.Comparator;

public class AtraccionComparator implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion o1, Atraccion o2) {

		int resultado=0;
		if(o1.getPrecioObj()>o2.getPrecioObj() ||  o1.getPrecioObj()==o2.getPrecioObj() && o1.getDuracionOj()>o2.getDuracionOj() )
               resultado= 1;
		else if (o1.getPrecioObj()< o2.getPrecioObj() )
		        resultado = -1;
			
		return -1 *resultado;
}
}
	
	/*int comparacion = 0;

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
*/