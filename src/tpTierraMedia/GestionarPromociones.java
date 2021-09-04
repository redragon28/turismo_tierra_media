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
				    String descuento = Integer.parseInt(valores[3]);
				    String descuento2 = valores[3];
				    
				    /*
				    int j;
				    if(valores[3]== "PAISAJE") {
				    	j=1;}
				    if(valores[3]== "AVENTURA") {
				    	j=2;}
				    else {j= 3;}
				    TipoAtraccion valor =  TipoAtraccion.values()[j];
				    */
				    
				    TipoAtraccion valor = Enum.valueOf (TipoAtraccion.class ,valores[3]);
				     
				    // posibles soluciones aal parametro , hayq  dejar una
				                                        
					
					Usuario nuevaPromocion = new Promocion(nombre, presupuesto, tiempo , valor);
					listaPromociones.add(nuevaPromocion);
					
					
					linea = br.readLine();
					
					
					//Hay que ver el valor[3] para que de con tipoPreferido o cambiar el parametro a un String//
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


}
