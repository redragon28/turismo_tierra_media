package tpTierraMedia;

import java.util.Comparator;

public class DuracionComparator implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return Double.compare(a1.getDuracion(), a2.getDuracion());

	}

}
