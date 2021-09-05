package tpTierraMedia;

import java.util.Comparator;

public class TipoComparator implements Comparator<Atraccion> {

	@Override
	public int compare(Atraccion a1, Atraccion a2) {
		return a1.getTipo().compareTo(a2.getTipo());

	}

}
