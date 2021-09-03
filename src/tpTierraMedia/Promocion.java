package tpTierraMedia;

import java.util.List;

public abstract class Promocion {

	protected String nombre;
	protected List<Atraccion> atracciones;

	public Double getPrecio() {
		Double costoTotal = 0.0;
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

}