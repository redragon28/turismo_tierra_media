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
	public  String getNombre() {
	return nombre;
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

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setTipo(TipoAtraccion tipo) {
		this.tipo = tipo;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}

	public void setCupoPersonas(int cupoPersonas) {
		this.cupoPersonas = cupoPersonas;
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

	@Override
	public String toString() {
		return "Atraccion [nombre=" + nombre + ", tipo=" + tipo + ", precio=" + precio + ", duracion=" + duracion
				+ ", cupoPersonas=" + cupoPersonas + "]";
	}

}
