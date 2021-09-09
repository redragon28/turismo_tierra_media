package tpTierraMedia;

import java.util.List;

public class Usuario {

	private String nombre;
	public int presupuesto;
	public double tiempoDisponible;
	private TipoAtraccion tipoPreferido;

	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoAtraccion tipoPreferido) {
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


	
	public String getNombre() {
		return nombre;
	}

	public int getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TipoAtraccion getTipoPreferido() {
		return tipoPreferido;

	}

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempoDisponible=" + tiempoDisponible
				+ ", tipoPreferido=" + tipoPreferido + "]";
	}

	}

