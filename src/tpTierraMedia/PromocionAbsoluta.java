package tpTierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	
	private double valorPaquete;
	
	public PromocionAbsoluta ( String nombre,double precio, List<Atraccion> atracciones ) {
		super(nombre,atracciones);
		this.valorPaquete=precio;
		
	}
	

	public double getPromocion() {
	return this.valorPaquete;
}
    
	}

