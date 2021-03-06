package tpTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(String nombre, List<Atraccion> atracciones) {
		super(nombre, atracciones);

	}

	@Override
	public double getPrecio() {
		double valor = 0;
		for (int x = 0; x < atracciones.size() - 1; x++) {
			valor += atracciones.get(x).getPrecio();
		}
		return valor;
	}

	@Override
	public String visitaGratis() {
		return atracciones.get(atracciones.size() - 1).getNombre();
	}

	@Override
	public String toString() {
		return  nombre +"--"+ " "+ "precio:" + this.getPrecio() + " "+"tiempo:"+" " + this.getTiempoPromocion()+" " + "cupo:"+ this.getCupo() + " "+ atracciones + " "+ "Tendra gratis:" + this.visitaGratis();
	}

	@Override
	public int tipoPromocion() {
		return 1;
	}

	@Override
	public double getTiempoPromocion () {
    	double tiempo = 0.0;
    	for(Atraccion atraccionesEnPromo : atracciones) {
    		tiempo += atraccionesEnPromo.getDuracion();
    	}
    		return tiempo;
	/*public double getTiempoPromocion() {
		double tiempo = 0;
		for (int x = 0; x < atracciones.size() - 1; x++) {
			tiempo += atracciones.get(x).getDuracion();
		}
		return tiempo;
*/
	}

}
