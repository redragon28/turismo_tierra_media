package tpTierraMedia;

import java.util.ArrayList;
import java.util.List;


public class Atraccion {

	private String nombre;
	private TipoAtraccion tipo;
	private double precio;
	private double duracion;
	private int cupoPersonas;

	public Atraccion(TipoAtraccion tipo, double precio, double duracion, int cupoPersonas) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.precio = precio;
		this.duracion = duracion;
		this.cupoPersonas = cupoPersonas;
	}
	
	public List<TipoAtraccion> getListaTiposAtraccion() {
		List<TipoAtraccion> listaTipoAtraccion = new ArrayList<TipoAtraccion>();
		listaTipoAtraccion.add(tipo);
		return listaTipoAtraccion;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public double getDuracion() {
		return duracion;
	}

	public int getCupoPersonas() {
		return cupoPersonas;
	}

}
