package tpTierraMedia;

import java.util.List;

public class PromocionAxB extends Promocion {

	public PromocionAxB(String nombre, List<Atraccion> atracciones) {
		super(nombre, atracciones);
		
		
	}
	
public double getPromocion() {
	double valor = 0;
	for (int x=0 ; x < atracciones.size()-1; x++) {
		valor = atracciones.get(x).getPrecio() ;
	}
return valor;
}

public String VisitaGratis() {
	return atracciones.get(atracciones.size()).getNombre();
}

}
