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
		return Math.round(super.getPrecio() * (1 - (this.porcentaje)));

	}

	@Override
	public String toString() {
		return " Promo" + " "+ nombre + " "+  porcentaje + " "+  "precio:"+ " "+ this.getPrecio() + atracciones;
	}

	@Override
	public int tipoPromocion() {
		return 3;
	}

	@Override
	public double getTiempoPromocion() {
		return super.getTiempoPromocion();
	}

	@Override
	protected String visitaGratis() {
		return "No posee";
	}
	

}
