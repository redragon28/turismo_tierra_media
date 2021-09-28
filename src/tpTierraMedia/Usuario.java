package tpTierraMedia;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

	private String nombre;
	public double presupuesto;
	public double tiempoDisponible;
	private TipoAtraccion tipoPreferido;
	private List<Atraccion> todasLasAtracciones;
	private List<Atraccion> atraccionesAdquiridas;
	private List<Promocion> promocionesAdquiridas;
	
	public Usuario(String nombre, int presupuesto, double tiempoDisponible, TipoAtraccion tipoPreferido) {
		this.nombre = nombre;
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferido = tipoPreferido;
		this.todasLasAtracciones = new ArrayList<Atraccion>();
		this.atraccionesAdquiridas = new ArrayList<Atraccion>();
		this.promocionesAdquiridas = new ArrayList<Promocion>();
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

	public double getPresupuesto() {
		return presupuesto;
	}

	public double getTiempoDisponible() {
		return tiempoDisponible;
	}

	public TipoAtraccion getTipoPreferido() {
		return tipoPreferido;

	}
	
	public List<Atraccion> getTodasLasAtracciones() {
		return todasLasAtracciones;
	}


	public List<Promocion> getPromocionesAdquiridas() {
		return promocionesAdquiridas;
	}

	public List<Atraccion> getAtraccionesAdquiridas() {
		return atraccionesAdquiridas;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setPresupuesto(double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public void setTiempoDisponible(double tiempoDisponible) {
		this.tiempoDisponible = tiempoDisponible;
	}

	public void setTipoPreferido(TipoAtraccion tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	public void setTodasLasAtracciones(List<Atraccion> todasLasAtracciones) {
		this.todasLasAtracciones = todasLasAtracciones;
	}


	@Override
	public String toString() {
		return  nombre + ", presupuesto:" + presupuesto + ", tiempoDisponible:" + tiempoDisponible
				+ ", Preferencia:" + tipoPreferido ;
	}


	}

