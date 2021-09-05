package tpTierraMedia;

import java.util.List;

public class PromocionAbsoluta extends Promocion {

	private String nombrePaquete;
	private double valorPaquete;
	private String lugar1;
	private String lugar2;

	public PromocionAbsoluta (List<Atraccion> atracciones, String nombre , String lugar1 , String lugar2 , double precio ) {
		super(atracciones);
		this.nombrePaquete=nombre;
         this.valorPaquete=precio;
		this.lugar1=lugar1;
		this.lugar2=lugar2;
	
	
	}
	

	public double getPromocion() {
	return this.valorPaquete;
}

		
	}

