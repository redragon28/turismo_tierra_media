package tpTierraMedia;

import java.util.ArrayList;
import java.util.List;

public class ShowPromociones {

	public List<Promocion> FIltarPromocionesPorInteres(List<Promocion> lista, Usuario persona){
		List <Promocion> reserva = new ArrayList<>();
		for(Promocion i : lista)
			if(i.getPreferenciaPromo().equals(persona.getTipoPreferido()))
				reserva.add(i);
		return reserva;
		}
	
	
	
}
