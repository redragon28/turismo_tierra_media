package tpTierraMedia;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArmadoItinerario {
	
	

	public  static List<Adquiribles> armadoItinerario(Promocion elegida , List<Atraccion> elegido ){
		List<Adquiribles> itinerario = new ArrayList <>();
		itinerario.add(elegida);
		
		itinerario.addAll(elegido);
		
		
		return itinerario;
		
		
	}
	
	

}
