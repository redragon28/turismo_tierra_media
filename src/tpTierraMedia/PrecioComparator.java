package tpTierraMedia;

import java.util.Comparator;

public class PrecioComparator implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return Double.compare(a1.getPrecio(), a2.getPrecio());

	}

}
