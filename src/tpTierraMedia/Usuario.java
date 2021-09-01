package tpTierraMedia;

public class Usuario {
	
	private int presupuesto;
	private int tiempoDisponible;
	private TipoAtraccion tipoPreferido;
	
	public Usuario(int presupuesto, int tiempoDisponible,
			TipoAtraccion tipoPreferido) {
		this.presupuesto = presupuesto;
		this.tiempoDisponible = tiempoDisponible;
		this.tipoPreferido = tipoPreferido;
	}

}
