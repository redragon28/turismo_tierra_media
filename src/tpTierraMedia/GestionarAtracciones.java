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

public static List<Atraccion> mostrarAtracciones(List<Atraccion> lista , Usuario persona ,Promocion obtenida) {
	List<Atraccion> preferidas= new ArrayList<>();
	for(Atraccion i : lista) {
		if(i.getTipo().equals(persona.getTipoPreferido())  && i.getPrecio()<persona.getPresupuesto() && i.getDuracion()< persona.getTiempoDisponible()){
			preferidas.add(i);
			
		}
	}
	if(preferidas.isEmpty()) {
		for(Atraccion j : lista) {
		if(!j.getTipo().equals(persona.getTipoPreferido())  && j.getPrecio()<persona.getPresupuesto() && j.getDuracion()< persona.getTiempoDisponible()){
			preferidas.add(j);
	}
	}
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
	
	 
public static Atraccion elegirAtraccion( List<Atraccion> lista ,Usuario persona, Promocion obtenida){
	List<Atraccion> promoOfrecidas = mostrarAtracciones(lista, persona,obtenida );	
	Atraccion elegida=null;
		
		
		
		String entrada = Consola.leerIn();
		
		for(Atraccion i : promoOfrecidas ) {
			if(entrada.equals(i.getNombre().toUpperCase())) {
		    elegida=i;
		    persona.setPresupuesto(persona.getPresupuesto()-i.getPrecio());
		    persona.setTiempoDisponible(persona.getTiempoDisponible()-i.getDuracion());
		     //promoOfrecidas.remove(i);
		     System.out.println("Eligio "+ entrada);
		     System.out.println("usted le queda "+ persona.toString());
			}
		}
		System.out.println("\n"+"generando Itinerario...");
		return elegida;
			
		
			
		
	}	

public static List<Atraccion> mostrarAtraccionNoPreferidas(List<Atraccion> lista , Usuario persona) {
	List<Atraccion> noPreferidas= new ArrayList<>();
	for(Atraccion i : lista) {
		if(!i.getTipo().equals(persona.getTipoPreferido())  && i.getPrecio()<persona.getPresupuesto() && i.getDuracion()< persona.getTiempoDisponible()){
			
			noPreferidas.add(i);
			System.out.println(i);
}
	}
	return noPreferidas;
}


public static void main(String[] args) {
		
		System.out.println(GestionarAtracciones.readAtraccionesFileAndCreateList().toString());
	}
}
