package tpTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionarPromociones {

	public static List<Promocion> readPromocionFileAndCreateList() {

		FileReader fr = null;
		BufferedReader br = null;

		List<Promocion> listaPromociones = new ArrayList<>(); // conviene list o LINkList?3

		try {

			fr = new FileReader("Archivos/Promociones.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while ((linea != null)) {
				String[] valores = linea.split(",");
				String valor3 = valores[3];
				
				if(!esNumero(valor3)){
	            Promocion nuevaPromocion = new PromocionAxB(valores[0],atraccionesInvolucrada(valores) );
					listaPromociones.add(nuevaPromocion);
					break;
				}
				double Valor3 = Double.parseDouble(valores[3]);
				if(Valor3> 1) {
					Promocion nuevaPromocion = new PromocionAbsoluta(valores[0],Valor3,atraccionesInvolucrada(valores));
					listaPromociones.add(nuevaPromocion);
				}else {
					Promocion nuevaPromocion = new PromoPorcentual(valores[0],Valor3,atraccionesInvolucrada(valores));
					listaPromociones.add(nuevaPromocion);
				}

			
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
		return listaPromociones;
	}		

	 // busca mediante las atracciones mencionadas en el archivo
	
	

	public static List<Atraccion> atraccionesInvolucrada(String[] valores) {
		List<Atraccion> atraccionesInvolucradas = new ArrayList<>();
		for (int i = 1; i < valores.length-1; i++) {
			atraccionesInvolucradas.add(buscadorAtraccion(valores[i]));
		}
		return atraccionesInvolucradas;
	}
	
	public static boolean esNumero (String valor) {
	return	valor.matches("[-+]?\\d*\\.?\\d+");
	
	}
	// busca en el array los objetos que represtan los lugares.
	public static Atraccion buscadorAtraccion(String nombre) {
		Atraccion resultado = null;

		for (Atraccion atraccion : GestionarAtracciones.readAtraccionesFileAndCreateList()) {
			if (atraccion.getNombre().toUpperCase().equals(nombre.trim().toUpperCase())) { // revisar esto a ver si equals.(valores.trim())
				resultado = atraccion;
			}
		}
		return resultado;
	}
	
	public static List<Promocion> mostrarPromociones(List<Promocion> lista ,Usuario persona) {
		List<Promocion> promoPreferida = new ArrayList<>();
		
		for(Promocion i : lista) {
			if(i.getPreferenciaPromo().equals(persona.getTipoPreferido())) {
				if(persona.getPresupuesto()>i.getPrecio() && persona.getTiempoDisponible()>i.getTiempoPromocion())
				promoPreferida.add(i);
			
		}
		}
		
		
		if(promoPreferida.isEmpty()) {
			System.out.println(" Usted no posee suficiente Dinero / tiempo para adquirir una Promocion" + "\n");
		}
		else
		System.out.println(" Estas son las Promociones recomendadas para usted. Escriba el nombre para elegir la promocion \n");
		for(Promocion j: promoPreferida) {
		System.out.println(j + "\n");
		}
		return promoPreferida;
		
	}
	
	public static  Promocion eleccionPromocion( List<Promocion> lista ,Usuario persona){
		Promocion elegida=null;
		List<Promocion> promoOfrecidas = mostrarPromociones(lista, persona);
		
		
		String entrada = Consola.leerIn();
		
		for(Promocion i : promoOfrecidas ) {
			if(entrada.equals(i.nombre.toUpperCase())) {
		    elegida=i;
		    for(Atraccion j : i.getAtracciones()) {
		    	j.setCupoPersonas();
		    }
		    	
		    persona.setPresupuesto(i.getPrecio());
		    persona.setTiempoDisponible(i.getTiempoPromocion());
		     System.out.println("\n");
		     System.out.println("Eligio "+ entrada +"\n");
		     
		     System.out.println("Actualizacion Usuario: "+ persona.toString() +"\n");
			}
		
		}
		return elegida;
			
		}
	
	
	public List<Promocion> ordenarPromocion(List<Promocion> lista){
		List<Promocion> promosOrdenadas = new ArrayList<>();
	return 	promosOrdenadas;
	}
public static void main(String[] args) {
		
		System.out.println(GestionarPromociones.readPromocionFileAndCreateList().toString());
		
		
	}
	}
