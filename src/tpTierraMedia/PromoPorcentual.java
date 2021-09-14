package tpTierraMedia;

import java.util.List;

import tpTierraMedia.Atraccion;

public class PromoPorcentual extends Promocion {
	private double porcentaje;

	public PromoPorcentual(String nombre, double porcentajeDescuento, List<Atraccion> atracciones) {
		super(nombre, atracciones);
		this.porcentaje = porcentajeDescuento;

	}

	public double getPorcentaje() {
		return porcentaje;
	}

	@Override
	public double getPrecio() {
		return super.getPrecio() * (1 - (this.porcentaje));

	}

	@Override
	public String toString() {
		return "PromoPorcentual [porcentaje=" + porcentaje + ", nombre=" + nombre + ", atracciones=" + atracciones
				+ "]";
	}

	@Override
	public int tipoPromocion() {
		return 3;
	}

	@Override
	public double duracionPromocion() {
		double horas = 0;

		for (Atraccion atraccion : this.atracciones) {
			horas += atraccion.getDuracion();
		}
		return horas;
	}

	@Override
	public double precioPromocion() {
		double costo = 0;

		for (Atraccion atraccion : this.atracciones) {
			costo += atraccion.getPrecio();
		}
		costo = costo - (costo * this.getPorcentaje());
		return costo;
	}

	@Override
	protected String visitaGratis() {
		return null;
	}

}
