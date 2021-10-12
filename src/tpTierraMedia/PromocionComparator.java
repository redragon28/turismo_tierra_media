package tpTierraMedia;

import java.util.Comparator;

public class PromocionComparator implements Comparator<Promocion> {

	

		@Override
		public int compare(Promocion o1, Promocion o2) {

			int resultado=0;
			if(o1.getPrecio()>o2.getPrecio() ||  o1.getPrecio()==o2.getPrecio() && o1.getTiempoPromocion()>o2.getTiempoPromocion() )
	               resultado= 1;
			else if (o1.getPrecio()< o2.getPrecio() )
			        resultado = -1;
					
			return -1 *resultado;
}
}
