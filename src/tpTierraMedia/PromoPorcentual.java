package tpTierraMedia;

import java.util.List;

import tpTierraMedia.Atraccion;


public class PromoPorcentual extends Promocion {
    private String nombrepaquete;
	private  double porcentaje;
	private  String lugar1;
	private String lugar2;
	
    
	public PromoPorcentual (String nombre , String lugar1 , String lugar2 , double porcentajeDescuento ,List<Atraccion> atracciones) {
		super(atracciones);
		this.nombrepaquete=nombre;
         this.porcentaje=porcentajeDescuento;
		this.lugar1=lugar1;
		this.lugar2=lugar2;
		
		
	}
	
	
	
	public double getPromocion () {
		return super.getPrecio()* (1-(this.porcentaje));
	
}
}

  