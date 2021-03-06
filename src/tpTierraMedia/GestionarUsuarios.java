package tpTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionarUsuarios {

	

	public static List<Usuario> readUsuariosFileAndCreateList() {


		FileReader fr = null;
		BufferedReader br = null;
		
		List<Usuario> listaUsuarios = new ArrayList<>();

		try {

			fr = new FileReader("Archivos/Usuarios.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while ((linea != null)) {
				String[] valores = linea.split(",");
				
				String nombre= valores[0];
				int presupuesto= Integer.parseInt(valores[1]);
			    double tiempo = Double.parseDouble(valores[2]);
			    
			   
			    
			   /* int j;
			    if(valores[3]== "PAISAJE") {
			    	j=1;}
			    if(valores[3]== "AVENTURA") {
			    	j=2;}
			    else {j= 3;}
			    
			    TipoAtraccion valor =  TipoAtraccion.values()[j]; */
			    
			    TipoAtraccion valor = Enum.valueOf (TipoAtraccion.class ,valores[3]);
			     
			    // posibles soluciones aal parametro , hayq  dejar una
			                                        
				
				Usuario nuevoUsuario = new Usuario(nombre, presupuesto, tiempo , valor);
				listaUsuarios.add(nuevoUsuario);
				
				
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
		
		return listaUsuarios;
	}
	
	public static void main(String[] args) {
		
		System.out.println(GestionarUsuarios.readUsuariosFileAndCreateList().toString());
	}
		
	
	public  static void MostrarUsuarios (List<Usuario> lista) {
		for(Usuario i : lista) {
		System.out.println(i);
		System.out.print("\n");
		}
	}
		
	public static Usuario eleccionUsuario(List<Usuario> lista) {
			
			Usuario eleccion = null;
			
			do {
			System.out.println("Escriba el nombre del usuario a elegir"+"\n");
				String leer= Consola.leerIn();
				
			for( Usuario i : lista ) {
				if(i.getNombre().equalsIgnoreCase(leer)) {
					eleccion= i;
				  System.out.println("usted eligio "+ eleccion + "\n");
				}
			}
			   
			
			}while (eleccion== null);
	
			
			
				
			return eleccion;
			
		}
		
	}
	



