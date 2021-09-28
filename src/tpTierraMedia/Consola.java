package tpTierraMedia;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Consola {

	
	public static String leerIn() {
			String valorEntrada ;
			Scanner scanner = new Scanner(new InputStreamReader(System.in));

		    valorEntrada = scanner.nextLine().toUpperCase();
			
              return valorEntrada;
              
              }
			
	
	public static String inicioApp() {
	String valorEntrada2 ;
			Scanner scanner2 = new Scanner(new InputStreamReader(System.in));

		    valorEntrada2 = scanner2.nextLine().toUpperCase();
			
              return valorEntrada2;
	}
	
 public static void metodoSaludar() {
	
            System.out.println("Bienvenido a Tierra Media" );
        	System.out.println("¿Desea Iniciar la Aplicacion?  SI/NO" );

}



/*

public static void main(String[] args) {
	metodoSaludar();
	valorEntrada="";
	while(!valorEntrada.equalsIgnoreCase("Finish")){
	System.out.println("¿Desea armar su intinerario?" +"\n" + "Si / Finish");
	leerConsola();
	System.out.println("Podria tipear su nombre");
	leerConsola();
	
	
	/*if(valorEntrada.equalsIgnoreCase("todo bien")) {
		System.out.println("usted es un maldito idiota");
	}
		else { System.out.println("");
		
	*/
	}


