package tpTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionarPromociones {

	public List<Promocion> readPromocionFileAndCreateList() {


			FileReader fr = null;
			BufferedReader br = null;
			
			List<Promocion> listaPromociones = new ArrayList<>();  // es mejor una linkedlist o arraylist?
				try {

				fr = new FileReader("Archivos/Usuarios.txt");
				br = new BufferedReader(fr);

				String linea = br.readLine();
				while ((linea != null)) {
					String[] valores = linea.split(",");
					
					String nombre= valores[0];
					int nombreLugar1= Integer.parseInt(valores[1]);
				    int nombreLugar2 = Integer.parseInt(valores[2]);
				    int descuento = Integer.parseInt(valores[3]);
				   
				   
				   // TipoAtraccion valor = Enum.valueOf (TipoAtraccion.class ,valores[3]);
				     
				    // posibles soluciones aal parametro , hayq  dejar una
				                                        
					Promocion Promocion = new Promocion(nombre, nombreLugar1, nombreLugar2 , descuento, list atraccion);
					listaPromociones.add(nuevaPromocion);
								
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

}
