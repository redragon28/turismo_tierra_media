package tpTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class GestionarAtracciones {


public static List<Atraccion> readAtraccionesFileAndCreateList() {

		FileReader fr = null;
		BufferedReader br = null;

		List<Atraccion> listaAtracciones = new ArrayList<>(); // conviene list o LINkList?3

		try {

			fr = new FileReader("Archivos/Atracciones.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while ((linea != null)) {
				String[] valores = linea.split(";");

				String nombre = valores[0];
				int costo = Integer.parseInt(valores[1]);
				double tiempo = Double.parseDouble(valores[2]);
				int cupo = Integer.parseInt(valores[3]);

				TipoAtraccion valor = Enum.valueOf(TipoAtraccion.class, valores[4]);

				Atraccion nuevaAtraccion = new Atraccion(nombre, costo, tiempo, cupo, valor);
				listaAtracciones.add(nuevaAtraccion);

				linea = br.readLine();

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}  
		return listaAtracciones;
		
		}



	
public static List<Atraccion> guardadoAtraccionesElegidas(List<Atraccion> lista ,Usuario persona, List<Promocion> obtenida){
	List<Atraccion> atraccionesElegidas= new ArrayList<>();
	List<Atraccion> atraccionesOfrecidas = lista;
	
	
	while( condicionMinimaParaConseguirAtraccion ( atraccionesOfrecidas, persona,obtenida) ) {
		System.out.println("elija la atraccion que le interese"+ "\n" + "o Solo escriba Siguiente" +"\n");
		List<Atraccion> ofrecidas= mostrarAtraccionesPreferidas(atraccionesOfrecidas, persona,obtenida);
		String entrada =Consola.leerIn();
		if(entrada.equalsIgnoreCase("siguiente") ){
	    	  break;
	    	  }
	Atraccion elegida=elegirAtraccion(ofrecidas, persona, entrada);
	  atraccionesElegidas.add(elegida);
      atraccionesOfrecidas.remove(elegida);
     
      
      }
	while(condicionMinimaParaConseguirAtraccionNoPreferida ( atraccionesOfrecidas, persona,obtenida)) {
		System.out.println("elija la atraccion No deseada que le interese,  o solo escriba Siguiente"+ "\n");
		List<Atraccion> ofrecidas2=mostrarAtraccionNoPreferida(atraccionesOfrecidas ,  persona);
		String entrada =Consola.leerIn();
		if(entrada.equalsIgnoreCase("siguiente") ){
	    	  break;
	    	  }
	Atraccion elegida2 =elegirAtraccion(ofrecidas2, persona, entrada);
	atraccionesElegidas.add(elegida2);
    atraccionesOfrecidas.remove(elegida2);

    
   
}System.out.println( "\n"+"No le alcanza para agregar una Atraccion, o no agrego ninguna mas al itinerario");
System.out.println("generando Itinerario...");
System.out.println("\n");
atraccionesOfrecidas.addAll(atraccionesElegidas);
	return atraccionesElegidas;
}

public static Atraccion elegirAtraccion( List<Atraccion> lista ,Usuario persona, String entrada){
	
	Atraccion elegida = null;
	
	  	  
		//String entrada = Consola.leerIn();
		for(Atraccion l : lista ) {
			if(entrada.equalsIgnoreCase(l.getNombre())) {
		        elegida=l;
		        l.setCupoPersonas();
		   // elegida.setCupoPersonas();
		    persona.setPresupuesto(l.getPrecio());
		    persona.setTiempoDisponible(l.getDuracion());
		     System.out.println("Eligio "+ entrada+ "\n");
		     System.out.println("\n");
		     System.out.println("Actualizacion Usuario:"+ persona.toString()+ "\n");
		     System.out.println("\n");
		     break;
			}
			
		}
		
		return elegida;
			
}
		
	
public  static boolean condicionMinimaParaConseguirAtraccion (List<Atraccion> lista, Usuario persona,List<Promocion> obtenida){
	boolean valorMinimo = true;
	for(Atraccion i :lista) {
		valorMinimo=true;
			
			for(Promocion r : obtenida)	{
			for(Atraccion j :r.getAtracciones()) {
					if(i.getNombre().equalsIgnoreCase(j.getNombre())) {
				
		
			valorMinimo=false; 
			break;
					}
			}
			if(valorMinimo == false)
				break;
			}if(valorMinimo==true && i.getPrecio() <= persona.presupuesto && i.getDuracion() <= persona.tiempoDisponible && i.getCupoPersonas()>0 && i.getTipo().equals(persona.getTipoPreferido()) ) {
				break;}
			else valorMinimo = false;
			

	}
	return valorMinimo;
}
public  static boolean condicionMinimaParaConseguirAtraccionNoPreferida (List<Atraccion> lista, Usuario persona,List<Promocion> obtenida){
	boolean valorMinimo = true;
	for(Atraccion i :lista) {
		valorMinimo=true;
				
			for(Promocion r : obtenida)	{
			for(Atraccion j :r.getAtracciones()) {
					if(i.getNombre().equals(j.getNombre())) 
				
		
			valorMinimo=false; 
			break;
			}
			if(valorMinimo == false)
				break;
			}if(valorMinimo==true && i.getPrecio() <= persona.presupuesto && i.getDuracion() <= persona.tiempoDisponible && i.getCupoPersonas()>0 && !i.getTipo().equals(persona.getTipoPreferido()))
				break;
			else valorMinimo = false;

	}
	return valorMinimo;
}


public static  List<Atraccion> mostrarAtraccionesPreferidas(List<Atraccion> lista , Usuario persona, List<Promocion> elegidas) {
	List<Atraccion> preferidas= new ArrayList<>();
	boolean k = true;
	for(Atraccion i : lista) {
		k= true;
		  for (Promocion s :elegidas ) {
			      for(Atraccion j : s.getAtracciones()) {
						if((i.getNombre().equals(j.getNombre()))){
							k= false;
							break;
			
			
						}
		  }	
		  if(k== false) {break;}
		 
		} 
		  if(k== false) {continue;}
		  else if (i.getTipo().equals(persona.getTipoPreferido())  && i.getPrecio()<=persona.getPresupuesto() && i.getDuracion()<= persona.getTiempoDisponible()) {
				preferidas.add(i);
				
		}
	}
		 ordenarAtracciones(preferidas);
		if(!preferidas.isEmpty()) {
		for(Atraccion z : preferidas) {
		System.out.println(z);
		}
		}
		
		else {System.out.println("no hay atracciones Preferidas acorde a su Perfil.");

		}
		
		return preferidas;
		
	}
		
	

public static List<Atraccion> mostrarAtraccionNoPreferida(List<Atraccion> lista , Usuario persona) {
	List<Atraccion> noPreferidas= new ArrayList<>();
	for(Atraccion i : lista) {
		if(!i.getTipo().equals(persona.getTipoPreferido())  && i.getPrecio()<=persona.getPresupuesto() && i.getDuracion()<= persona.getTiempoDisponible()){
			
			noPreferidas.add(i);	
}
	}
		ordenarAtracciones(noPreferidas);
		if(!noPreferidas.isEmpty()) {
			for(Atraccion j : noPreferidas) {
				 System.out.println(j);
			}
		} else System.out.println("Usted no posee suficiente Dinero/ tiempo para adquirir una atraccion.");
		
	
	return noPreferidas;
}

public static List<Atraccion> ordenarAtracciones(List<Atraccion> lista) {
	List<Atraccion> atraccionesOrdenadas= new ArrayList<>();
	atraccionesOrdenadas= lista;
	lista.sort(new AtraccionComparator());
	
	
	return atraccionesOrdenadas;
}


		

public static void main(String[] args) {
		
		System.out.println(GestionarAtracciones.readAtraccionesFileAndCreateList().toString());
	}
}
