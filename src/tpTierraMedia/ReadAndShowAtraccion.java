package tpTierraMedia;

import java.util.List;

public class ReadAndShowAtraccion {

	
	
	public Atraccion  showAtraccionMasCara (List<Atraccion> lista) {
		Atraccion reserva = null;
		for(Atraccion i : lista)
		     
		         if(i.compare(i, reserva)>0)
		        	 reserva= i;
		return(reserva);		
	}
	
	{
		/*
	public List<Atraccion> OrdenAtraccionesMasCaras(){
		
		}
	*/
	}
}
