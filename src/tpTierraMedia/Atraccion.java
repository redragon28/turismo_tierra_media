package tpTierraMedia;

public class Atraccion {

	private TipoAtraccion tipo;
	private double precio;
	private int duracion;
	private int cupoPersonas;

	public Atraccion(TipoAtraccion tipo, double precio, int duracion, int cupoPersonas) {
		this.tipo = tipo;
		this.precio = precio;
		this.duracion = duracion;
		this.cupoPersonas = cupoPersonas;
	}

	public TipoAtraccion getTipo() {
		return tipo;
	}

	public double getPrecio() {
		return precio;
	}

	public int getDuracion() {
		return duracion;
	}

	public int getCupoPersonas() {
		return cupoPersonas;
	}

}
