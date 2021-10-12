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
		return nombre+ "--" + " "+ "costo:" + valorPaquete + " "+"tiempo"+" "+ this.getTiempoPromocion() + " "+ "cupo:"+" "+ this.getCupo() +  atracciones ;
	}

	@Override
	public int tipoPromocion() {
		return 2;
	}


	@Override
	public double getTiempoPromocion() {
		return super.getTiempoPromocion();
	}



	@Override
	protected String visitaGratis() {
		return null;
	}

	
}
