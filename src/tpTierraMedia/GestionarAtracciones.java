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


//public Atraccion eleccionAtraccion() {
	
	
//}
//solo muestra las atracciones.
public static List<Atraccion> mostrarAtracciones(List<Atraccion> lista , Usuario persona ,Promocion obtenida) {
	List<Atraccion> preferidas= new ArrayList<>();
	for(Atraccion i : lista) {
		if(i.getTipo().equals(persona.getTipoPreferido())  && i.getPrecio()<persona.getPresupuesto() && i.getDuracion()< persona.getTiempoDisponible()){
			preferidas.add(i);
			
		}
		ordenarAtracciones(preferidas);
	}
	if(preferidas.isEmpty()) {
		mostrarAtraccionNoPreferida(lista ,persona);
		/*for(Atraccion j : lista) {
		if(!j.getTipo().equals(persona.getTipoPreferido())  && j.getPrecio()<persona.getPresupuesto() && j.getDuracion()< persona.getTiempoDisponible()){
			preferidas.add(j);*/
	
		ordenarAtracciones(preferidas);
	
	}
	else if (preferidas.isEmpty()) {
		System.out.println(" Usted no posee suficiente Dinero / tiempo para adquirir una Atraccion" + "\n");
	}
    else {
    	System.out.println("seleccione una atraccion:" + "\n");
		for(Atraccion j: preferidas) {
		System.out.println(j + "\n");
	}
	}
	
	return preferidas;
	}
	
	 
public static List<Atraccion> guardadoAtraccionesElegidas(List<Atraccion> lista ,Usuario persona, Promocion obtenida){
	List<Atraccion> atraccionesElegidas= new ArrayList<>();
	
	if( condicionMinimaParaConseguirAtraccion ( lista, persona) )
		System.out.println("eliga la atraccion que le interese"+ "\n");
	
	  atraccionesElegidas.add(elegirAtraccion(mostrarAtraccionesPreferidas(lista, persona,obtenida), persona, obtenida));
	  atraccionesElegidas.add(elegirAtraccion(mostrarAtraccionNoPreferida(lista ,  persona), persona, obtenida));
       System.out.println("generando Itinerario...");
	
	return atraccionesElegidas;
}

public static Atraccion elegirAtraccion( List<Atraccion> lista ,Usuario persona, Promocion obtenida){
	//List<Atraccion> AtraccionesPreferidas = mostrarAtraccionesPreferidas(lista, persona,obtenida );	
	//List<Atraccion> AtraccionesNopreferidas = mostrarAtraccionNoPreferida( lista ,persona);
	Atraccion elegida = null;
		String entrada = Consola.leerIn();
		for(Atraccion i : lista ) {
			if(entrada.equals(i.getNombre().toUpperCase())) {
		        elegida=i;
		   // elegida.setCupoPersonas();
		    persona.setPresupuesto(persona.getPresupuesto()-i.getPrecio());
		    persona.setTiempoDisponible(persona.getTiempoDisponible()-i.getDuracion());
		     System.out.println("Eligio "+ entrada+ "\n");
		     System.out.println("\n");
		     System.out.println("usted le queda "+ persona.toString()+ "\n");
		     System.out.println("\n");
			}
			
		}
		//System.out.println("\n"+"generando Itinerario...");
		return elegida;
			
}
		
	
public  static boolean condicionMinimaParaConseguirAtraccion (List<Atraccion> lista, Usuario persona){
	boolean valorMinimo = false;
	for(Atraccion i :lista) {
		if (i.getPrecio() <= persona.presupuesto && i.getDuracion() <= persona.tiempoDisponible) {
			if(i.getCupoPersonas()>0);
			valorMinimo=true; 
			break;
			}
}
	return valorMinimo;
}
public  static double condicionMinimaTIempoParaConseguirAtraccion (List<Atraccion> lista){
	double  valorMinimo = 1000000;
	for(Atraccion i :lista) {
		if (i.getDuracion() < valorMinimo ) {
			valorMinimo=i.getDuracion(); }
}
	return valorMinimo;
}

public static  List<Atraccion> mostrarAtraccionesPreferidas(List<Atraccion> lista , Usuario persona, Promocion elegida) {
	List<Atraccion> preferidas= new ArrayList<>();
	for(Atraccion i : lista) {
		if(i.getTipo().equals(persona.getTipoPreferido())  && i.getPrecio()<= persona.getPresupuesto() && i.getDuracion()<= persona.getTiempoDisponible() ){
			
			preferidas.add(i);
}
	}
		ordenarAtracciones(preferidas);
		if(!preferidas.isEmpty()) {
		for(Atraccion j : preferidas) {
		 System.out.println(j);
		}
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

/*public static void puedeAccederAUnaAtraccion(List<Atraccion> lista , Usuario persona) {

	for(Atraccion i :lista)
         if (i.getCupoPersonas()>0)	
        	 if(persona.getPresupuesto() > i.getPrecio() && persona.getPromocionesAdquiridas() > i.getDuracion())
        		
        		 
}
*/
		

public static void main(String[] args) {
		
		System.out.println(GestionarAtracciones.readAtraccionesFileAndCreateList().toString());
	}
}
