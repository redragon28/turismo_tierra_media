package tpTierraMedia;

import java.util.List;

public class Usuario {

	private String nombre;
	private int presupuesto;
	private int tiempoDisponible;
	private TipoAtraccion tipoPreferido;

	public Usuario(String nombre, int presupuesto, int tiempoDisponible, TipoAtraccion tipoPreferido) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferido = tipoPreferido;
	}
	
	public boolean esBuenPrecio(double precio) {
		return presupuesto >= precio;
	}
	
	public boolean esTiempoSuficiente(double duracion) {
		return tiempoDisponible >= duracion;
	}
	
	public boolean esAtraccionPreferida(List<TipoAtraccion> tipoAtraccion) {
		return tipoAtraccion.contains(tipoPreferido); 
	}

}
