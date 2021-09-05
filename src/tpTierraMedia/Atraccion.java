package tpTierraMedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Atraccion {

	private String nombre;
	private TipoAtraccion tipo;
	private double precio;
	private double duracion;
	private int cupoPersonas;

	public Atraccion(String nombre, double precio, double duracion, int cupoPersonas, TipoAtraccion tipo) {
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

	@Override
	public int hashCode() {
		return Objects.hash(cupoPersonas, duracion, nombre, precio, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return cupoPersonas == other.cupoPersonas
				&& Double.doubleToLongBits(duracion) == Double.doubleToLongBits(other.duracion)
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(precio) == Double.doubleToLongBits(other.precio) && tipo == other.tipo;
	}

}
