package tpTierraMedia;

import java.io.InputStreamReader;
import java.util.Scanner;


public class Consola {



public  static String valorEntrada;

//al inicio del programa saluda al usuario
public static void metodoSaludar() {
	
	System.out.println( "Bienvenido a la Aplicacion ,donde le falicitara encontrar la excursion de sus sueños  me llamo COMPUTADORA" );
	
}
//lee lo que el usuario disponga por entrada refereido o ante la consulta de ???
public static void leerConsola() {
	
Scanner scanner = new Scanner(new InputStreamReader(System.in));

 valorEntrada = scanner.nextLine().toUpperCase();

}


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
		
	
	}*/
}
	}
}

