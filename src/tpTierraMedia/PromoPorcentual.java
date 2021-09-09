package tpTierraMedia;

import java.util.List;

import tpTierraMedia.Atraccion;


public class PromoPorcentual extends Promocion {
 private  double porcentaje;
	
	
    
	public PromoPorcentual (String nombre , double porcentajeDescuento ,List<Atraccion> atracciones) {
		super(nombre,atracciones);
		this.porcentaje=porcentajeDescuento;
		
		
		
	}
	
	
	@Override
	public double getPrecio () {
		return super.getPrecio()* (1-(this.porcentaje));
	
}


	@Override
	public String toString() {
		return "PromoPorcentual [porcentaje=" + porcentaje + ", nombre=" + nombre + ", atracciones=" + atracciones
				+ "]";
	}



	



	}
	

  