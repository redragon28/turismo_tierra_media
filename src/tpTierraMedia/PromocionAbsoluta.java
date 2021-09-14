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

	@Override
	protected double precioPromocion() {
		double valorPaquete = this.valorPaquete;
		return valorPaquete;
	}

	@Override
	protected double duracionPromocion() {
		double horas =0;
		for (Atraccion atraccion : this.atracciones){
			horas += atraccion.getDuracion();
		}
		return horas;
	}

	@Override
	protected String visitaGratis() {
		return null;
	}

	
}
