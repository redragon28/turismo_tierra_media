package tpTierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private double valorPaquete;

	public PromocionAbsoluta(String nombre, double precio, List<Atraccion> atracciones) {
		super(nombre, atracciones);
		this.valorPaquete = precio;

	}

	@Override
	public double getPrecio() {
		return this.valorPaquete;
	}

	@Override
	public String toString() {
		return "PromocionAbsoluta [valorPaquete=" + valorPaquete + ", nombre=" + nombre + ", atracciones=" + atracciones
				+ "]";
	}

	@Override
	public int tipoPromocion() {
		return 2;
	}

}
