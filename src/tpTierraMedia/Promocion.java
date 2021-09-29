package tpTierraMedia;

import java.util.List;

public abstract class Promocion extends Adquiribles {

	protected String nombre;
	protected List<Atraccion> atracciones;

	public Promocion(String nombre, List<Atraccion> atracciones) {
		this.atracciones = atracciones;
		this.nombre = nombre;
	
	}

	public double getPrecio() {
		double costoTotal = 0.0;
		for (Atraccion atraccion : atracciones) {
			costoTotal += atraccion.getPrecio();
		}
		return costoTotal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public List<Atraccion> getAtracciones() {
		return this.atracciones;
	}
	
		
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

    
	public double getTiempoPromocion () {
    	double tiempo = 0.0;
    	for(Atraccion atraccionesEnPromo : atracciones) {
    		tiempo += atraccionesEnPromo.getDuracion();
    	}
    		return tiempo;
    }
	

	@Override
	public String toString() {
		return " nombre +  atracciones ";
	}

	public TipoAtraccion getPreferenciaPromo() {
		TipoAtraccion preferencia = null;
		for (Atraccion atraccionesEnPromo : atracciones) {
			preferencia = atraccionesEnPromo.getTipo();
		}

		return preferencia;
	}
	

	protected abstract int tipoPromocion();
	
	protected abstract String visitaGratis();
}
