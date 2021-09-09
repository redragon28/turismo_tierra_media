package tpTierraMedia;

import java.util.List;

public abstract class Promocion {

	protected String nombre;
	protected List<Atraccion> atracciones;
	
	public Promocion (String nombre, List<Atraccion> atracciones) {
		this.atracciones= atracciones;
		this.nombre= nombre;
	
	}

	

	public double getPrecio() {
		double costoTotal = 0.0;
		for (Atraccion atraccion : atracciones) {
			costoTotal += atraccion.getPrecio();
		}
		return costoTotal;
	}

	public String getNombre() {
		return nombre;
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
		return "Promocion [nombre=" + nombre + ", atracciones=" + atracciones + "]";
	}

	public TipoAtraccion getPreferenciaPromo() {
		TipoAtraccion preferencia;
		
		preferencia= ((Atraccion) atracciones).getTipo();
		
		
		return preferencia;
	}
	
	}





