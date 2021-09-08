package tpTierraMedia;

import java.util.List;

import tpTierraMedia.Atraccion;


public class PromoPorcentual extends Promocion {
 private  double porcentaje;
	
	
    
	public PromoPorcentual (String nombre , double porcentajeDescuento ,List<Atraccion> atracciones) {
		super(nombre,atracciones);
		this.porcentaje=porcentajeDescuento;
		
		
		
	}
	
	
	
	public double getPromocion () {
		return super.getPrecio()* (1-(this.porcentaje));
	
}
}

  