package tpTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(String nombre, List<Atraccion> atracciones) {
		super(nombre, atracciones);

	}

	@Override
	public double getPrecio() {
		double valor = 0;
		for (int x = 0; x < atracciones.size() - 1; x++) {
			valor += atracciones.get(x).getPrecio();
		}
		return valor;
	}

	public String visitaGratis() {
		return atracciones.get(atracciones.size()-1).getNombre();
	}

	@Override
	public String toString() {
		return "PromocionAxB [nombre=" + nombre + ", atracciones=" + atracciones + "]";
	}

	@Override
	public int tipoPromocion() {
		return 1;
	}
}
