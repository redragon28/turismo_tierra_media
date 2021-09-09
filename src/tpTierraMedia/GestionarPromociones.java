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
	            Promocion nuevaPromocion = new PromocionAxB(valores[1],atraccionesInvolucrada(valores) );
					listaPromociones.add(nuevaPromocion);
					break;
				}
				double Valor3 = Double.parseDouble(valores[3]);
				if(Valor3> 1) {
					Promocion nuevaPromocion = new PromocionAbsoluta(valores[1],Valor3,atraccionesInvolucrada(valores));
					listaPromociones.add(nuevaPromocion);
				}else {
					Promocion nuevaPromocion = new PromoPorcentual(valores[1],Valor3,atraccionesInvolucrada(valores));
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
		for (int i = 1; i <= valores.length-1; i++) {
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
			if (atraccion.getNombre() == nombre) { // revisar esto a ver si equals.(valores.trim())
				resultado = atraccion;
			}
		}
		return resultado;
	}
public static void main(String[] args) {
		
		System.out.println(GestionarPromociones.readPromocionFileAndCreateList().toString());
		
		
	}
	}
