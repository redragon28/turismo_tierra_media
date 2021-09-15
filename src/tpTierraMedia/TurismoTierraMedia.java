package tpTierraMedia;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class TurismoTierraMedia {
	private static List<Atraccion> listaAtracciones;
	private static List<Promocion> listaPromociones;
	private static List<Usuario> listaUsuarios;
	
	public static List<Usuario> readUsuariosFileAndCreateList() {

	listaUsuarios = new ArrayList<>();


		FileReader fr = null;
		BufferedReader br = null;
		

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
	
	
	public static List<Atraccion> readAtraccionesFileAndCreateList() {

		listaAtracciones = new ArrayList<>();
		FileReader fr = null;
		BufferedReader br = null;


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

	

		
		
	public static List<Promocion> readPromocionFileAndCreateList() {
		
		listaPromociones = new ArrayList<>();

		FileReader fr = null;
		BufferedReader br = null;


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


	public static void consola() {
		readAtraccionesFileAndCreateList();
		readPromocionFileAndCreateList();
		
		int eleccion = 1;
		while (eleccion != 99999) {
			// Si no hay mas usuarios se finaliza la ejecucion del programa
			   if (listaUsuarios.isEmpty()) { 
				System.out.println("--------- SE HAN PROCESADO TODOS LOS USUARIOS ---------");
				System.exit(0);
			}
			// Se crea el menu de opciones*/
			System.out.println("\nBienvenido a la tierra media!\nQue personaje te gustaria ser?");
			mostrarUsuarios();
			// Se selecciona el usuario que quiere ser
			System.out.println("\nIngrese el numero correspondiente a su personaje");
			// Se crea el objeto de tipo Scanner
			Scanner sc = new Scanner(new InputStreamReader(System.in));
			String entrada = sc.next();
			if (entrada.matches("-?\\d+(\\.,0\\d+)?")) {
				eleccion = (int) Double.parseDouble(entrada);
			} else {
				eleccion = listaUsuarios.size() + 1;
			}

			try {
				System.out.println("\nHas elegido ser: " + listaUsuarios.get(eleccion - 1).getNombre());
				// El objeto creado se usa para llamar al metodo sugerir
				sugerirAtraccion(listaUsuarios.get(eleccion - 1));
				eleccion = 99999;
			} catch (IndexOutOfBoundsException ex) {
				System.out
						.println("El valor ingresado solamente puede ser un entero entre 1 y " + listaUsuarios.size());
			}
		}
	}
	
	
	public static boolean esNumerico(String str) {
		// regexp para verificar si es numerico
		return str.matches("-?\\d+(\\.\\d+)?");
	}


	public static void sugerirAtraccion(Usuario usuario) {
		listaPromociones = actualizarListaPromociones(usuario);
		listaAtracciones = actualizarListaAtracciones(usuario);
		List<Promocion> promocionesRecomendadas = sugerenciasPromociones(usuario);
		List<Atraccion> atraccionesRecomendadas = sugerenciasAtraccionesPreferidas(usuario);
		List<Atraccion> otrasAtracciones = sugerenciasOtrasAtracciones(usuario);
		int cant_promos = promocionesRecomendadas.size();
		int cant_atrac = atraccionesRecomendadas.size();
		int cant_otrasAtrac = otrasAtracciones.size();

		int eleccion = 1;
		while (eleccion != 99999) {
			if (cant_promos != 0 && (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1)) {
				sugerirPromociones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
						eleccion);
			} else if (cant_atrac != 0 && (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1)) {
				sugerirAtraccionesPreferidas(usuario, promocionesRecomendadas, atraccionesRecomendadas,
						otrasAtracciones, eleccion);
			} else if (cant_otrasAtrac != 0 && (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1)) {
				sugerirOtrasAtracciones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
						eleccion);
			} else {
			borrarUsuario(usuario, eleccion);

			}
			}
		}
	
	
	public static void borrarUsuario(Usuario usuario, int eleccion) {
		System.out.println("No puedes realizar compras!");
		generarArchivo(usuario);
		eleccion = 99999;
		generarItinerario(usuario);
		listaUsuarios.remove(usuario);
		consola();
	}

	public static void sugerirPromociones(Usuario usuario, List<Promocion> promocionesRecomendadas,
			List<Atraccion> atraccionesRecomendadas, List<Atraccion> otrasAtracciones, int eleccion) {
		while (!promocionesRecomendadas.isEmpty()) {
			if (usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1) {
				if((usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1)) {
				// usuarioSinAtracciones(usuario, eleccion);
			borrarUsuario(usuario, eleccion);
			}
			}
			System.out.println("\nEstas son las promociones que tenemos para usted:");
			mostrarPromociones(promocionesRecomendadas);
			System.out.println("\nUsted tiene: " + usuario.getPresupuesto() + " monedas y "
					+ usuario.getTiempoDisponible() + " hs disponibles.");
			System.out.println("\nSi desea obtener una atraccion, por favor ingrese su numero");
			System.out.println("\nSi ya no desea continuar, pulse c");

			Scanner sc = new Scanner(new InputStreamReader(System.in));
				String valorEntrada = sc.nextLine();

				if (valorEntrada.equalsIgnoreCase("c")) {
					sugerirAtraccionesPreferidas(usuario, promocionesRecomendadas, atraccionesRecomendadas,
							otrasAtracciones, eleccion);
				}
				try {
					if (valorEntrada.matches("-?\\d+(\\.,0\\d+)?")) {
						eleccion = (int) Double.parseDouble(valorEntrada);
						System.out.println(
								"\nHas elegido la promocion: " + promocionesRecomendadas.get(eleccion - 1).getNombre());

						// Se actualizan horas, presupuesto e historial de promociones del usuario
						actualizarUsuarioPromocion(usuario, promocionesRecomendadas, eleccion - 1);
						actualizarPromocionesAdquiridas(usuario, promocionesRecomendadas, eleccion - 1);
						actualizarCupoAtraccionPromo(promocionesRecomendadas, eleccion - 1);

						listaPromociones = actualizarListaPromociones(usuario);
						listaAtracciones = actualizarListaAtracciones(usuario);
						promocionesRecomendadas = sugerenciasPromociones(usuario);
						atraccionesRecomendadas = sugerenciasAtraccionesPreferidas(usuario);
						otrasAtracciones = sugerenciasOtrasAtracciones(usuario);

					} else {
						eleccion = promocionesRecomendadas.size() + 1;
					}
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("El valor ingresado solamente puede ser un entero entre 1 y "
							+ promocionesRecomendadas.size());
				}
			}
			sugerirAtraccion(usuario);
		}


	public static void sugerirAtraccionesPreferidas(Usuario usuario, List<Promocion> promocionesRecomendadas,
			List<Atraccion> atraccionesRecomendadas, List<Atraccion> otrasAtracciones, int eleccion) {
		while (!atraccionesRecomendadas.isEmpty()) {
			if (usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1) {
				// usuarioSinAtracciones(usuario, eleccion);
				borrarUsuario(usuario, eleccion);
			}
			System.out.println("\nAtracciones recomendadas para usted:");
			ordenarAtraccionesPorPrecioYDuracion(atraccionesRecomendadas);
			mostrarAtracciones(atraccionesRecomendadas);
			System.out.println("\nUsted tiene: " + usuario.getPresupuesto() + " monedas y "
					+ usuario.getTiempoDisponible() + " hs disponibles.");
			System.out.println("\nSi desea obtener una atraccion, por favor ingrese su numero");
			System.out.println("\nSi ya no desea continuar, pulse c");

			Scanner sc = new Scanner(new InputStreamReader(System.in));
				String valorEntrada = sc.nextLine();

				if (valorEntrada.equalsIgnoreCase("c")) {
					sugerirOtrasAtracciones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
							eleccion);

				}
				try {
					if (valorEntrada.matches("-?\\d+(\\.,0\\d+)?")) {
						eleccion = (int) Double.parseDouble(valorEntrada);
						System.out.println(
								"\nHas elegido la promocion: " + promocionesRecomendadas.get(eleccion - 1).getNombre());

						// Se actualizan horas, presupuesto e historial de promociones del usuario
						actualizarUsuarioPromocion(usuario, promocionesRecomendadas, eleccion - 1);
						actualizarPromocionesAdquiridas(usuario, promocionesRecomendadas, eleccion - 1);
						actualizarCupoAtraccionPromo(promocionesRecomendadas, eleccion - 1);

						listaPromociones = actualizarListaPromociones(usuario);
						listaAtracciones = actualizarListaAtracciones(usuario);
						promocionesRecomendadas = sugerenciasPromociones(usuario);
						atraccionesRecomendadas = sugerenciasAtraccionesPreferidas(usuario);
						otrasAtracciones = sugerenciasOtrasAtracciones(usuario);

					} else {
						eleccion = promocionesRecomendadas.size() + 1;
					}
				} catch (IndexOutOfBoundsException ex) {
					System.out.println("El valor ingresado solamente puede ser un entero entre 1 y "
							+ promocionesRecomendadas.size());
				}
			}
			sugerirAtraccion(usuario);

		}
	

	public static void sugerirOtrasAtracciones(Usuario usuario, List<Promocion> promocionesRecomendadas,
			List<Atraccion> atraccionesRecomendadas, List<Atraccion> otrasAtracciones, int eleccion) {
		while (!atraccionesRecomendadas.isEmpty()) {
			if (usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1) {
				// usuarioSinAtracciones(usuario, eleccion);
				borrarUsuario(usuario, eleccion);
			}
			System.out.println("\nAtracciones recomendadas para usted:");
			ordenarAtraccionesPorPrecioYDuracion(otrasAtracciones);
			mostrarAtracciones(otrasAtracciones);
			System.out.println("\nUsted tiene: " + usuario.getPresupuesto() + " monedas y "
					+ usuario.getTiempoDisponible() + " hs disponibles.");
			System.out.println("\nSi desea obtener una atraccion, por favor ingrese su numero");
			System.out.println("\nSi ya no desea continuar, pulse c");

			Scanner sc = new Scanner(new InputStreamReader(System.in));
				String valorEntrada = sc.nextLine();

				if (valorEntrada.equalsIgnoreCase("c")) {
					sugerirPromociones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
							eleccion);
					try {
						if (valorEntrada.matches("-?\\d+(\\.,0\\d+)?")) {
							eleccion = (int) Double.parseDouble(valorEntrada);
							System.out.println("\nHas elegido la atraccion: "
									+ promocionesRecomendadas.get(eleccion - 1).getNombre());

							// Se actualizan horas, presupuesto e historial de promociones del usuario
							actualizarUsuarioPromocion(usuario, promocionesRecomendadas, eleccion - 1);
							actualizarPromocionesAdquiridas(usuario, promocionesRecomendadas, eleccion - 1);
							actualizarCupoAtraccion(atraccionesRecomendadas, eleccion - 1);

							listaAtracciones = actualizarListaAtracciones(usuario);
							promocionesRecomendadas = sugerenciasPromociones(usuario);
							atraccionesRecomendadas = sugerenciasAtraccionesPreferidas(usuario);
							otrasAtracciones = sugerenciasOtrasAtracciones(usuario);

						} else {
							eleccion = promocionesRecomendadas.size() + 1;
						}
					} catch (IndexOutOfBoundsException ex) {
						System.out.println("El valor ingresado solamente puede ser un entero entre 1 y "
								+ promocionesRecomendadas.size());
					}
				}
				sugerirAtraccion(usuario);
			}
		}


	public static List<Promocion> actualizarListaPromociones(Usuario usuario) {
		List<Promocion> promocionesActualizada = new ArrayList<Promocion>();
		List<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();

		for (Promocion promocion : listaPromociones) {
			if (!(usuario.getPromocionesAdquiridas().contains(promocion))) {
				atraccionesPromo = promocion.getAtracciones();
				int cont = 0;
				// Aca evalua si las atracciones de la promo estan en el historial de todas las
				// atracciones
				for (Atraccion ap : atraccionesPromo) {
					if ((usuario.getTodasLasAtracciones().contains(ap))) {
						cont++;
					}
				}
				// Aca evalua si la promocion es axb y en ese caso tiene que compara la
				// atraccion extra con las del historial de atracciones
				if (promocion.tipoPromocion() == 1) {
					for (Atraccion a : usuario.getTodasLasAtracciones()) {
						if (tipoAtraccionGratis(promocion).equals(a.getTipo())) {
							cont++;
						}
					}
				}
				if (cont == 0) {
					promocionesActualizada.add(promocion);
				}
			}
		}
		return promocionesActualizada;
	}

	public static List<Atraccion> actualizarListaAtracciones(Usuario usuario) {
		List<Atraccion> atraccionesActualizada = new ArrayList<Atraccion>();

		for (Atraccion atraccion : listaAtracciones) {
			if (!(usuario.getTodasLasAtracciones().contains(atraccion))) {
				atraccionesActualizada.add(atraccion);
			}
		}
		return atraccionesActualizada;
	}

	public static void actualizarAtraccionesAdquiridas(Usuario usuario, List<Atraccion> atracciones, int eleccion) {
		usuario.getAtraccionesAdquiridas().add(atracciones.get(eleccion));
		usuario.getTodasLasAtracciones().add(atracciones.get(eleccion));
	}

	public static void actualizarPromocionesAdquiridas(Usuario usuario, List<Promocion> promociones, int eleccion) {
		List<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();
		usuario.getPromocionesAdquiridas().add(promociones.get(eleccion));
		for (Promocion promo : usuario.getPromocionesAdquiridas()) {
			atraccionesPromo = promo.getAtracciones();
			for (Atraccion atracc : atraccionesPromo) {
				usuario.getTodasLasAtracciones().add(atracc);
				if (promo.tipoPromocion() == 1) {
					String gratis = promo.visitaGratis();
					for (Atraccion atraccL : listaAtracciones) {
						if (gratis.compareTo(atraccL.getNombre()) == 0) {
							usuario.getTodasLasAtracciones().add(atraccL);
						}
					}
				}
			}
		}
	}

	public static void actualizarUsuarioPromocion(Usuario usuario, List<Promocion> promociones, int eleccion) {
		usuario.setPresupuesto((int) (usuario.getPresupuesto() - promociones.get(eleccion).getPrecio()));
		usuario.setTiempoDisponible(usuario.getTiempoDisponible() - promociones.get(eleccion).getTiempoPromocion());
	}

	public static void actualizarUsuarioAtraccion(Usuario usuario, List<Atraccion> atracciones, int eleccion) {
		usuario.setPresupuesto((int) (usuario.getPresupuesto() - atracciones.get(eleccion).getPrecio()));
		usuario.setTiempoDisponible(usuario.getTiempoDisponible() - atracciones.get(eleccion).getDuracion());
	}

	public static void actualizarCupoAtraccionPromo(List<Promocion> promociones, int eleccion) {
		List<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();
		for (Atraccion a : listaAtracciones) {
			atraccionesPromo = promociones.get(eleccion).getAtracciones();
			for (Atraccion atracc : atraccionesPromo) {
				if ((a.getNombre()).compareTo(atracc.getNombre()) == 0) {
					a.setCupoPersonas(a.getCupoPersonas() - 1);
				}
			}
		}

		for (Promocion p : promociones) {
			if (p.tipoPromocion() == 1) {
				String gratis = p.visitaGratis();
				for (Atraccion atraccion : listaAtracciones) {
					if (gratis.compareTo(atraccion.getNombre()) == 0) {
						atraccion.setCupoPersonas(atraccion.getCupoPersonas() - 1);
					}
				}
			}
		}

	}

	public static void actualizarCupoAtraccion(List<Atraccion> atracciones, int i) {
		atracciones.get(i).setCupoPersonas(atracciones.get(i).getCupoPersonas() - 1);
	}

	public static List<Atraccion> sugerenciasAtraccionesPreferidas(Usuario usuario) {
		List<Atraccion> atraccionesRecomendadas = new ArrayList<Atraccion>();

		for (Atraccion atraccion : listaAtracciones) {
			if ((usuario.getTipoPreferido()).compareTo(atraccion.getTipo()) == 0) {
				if (atraccion.getCupoPersonas() > 0 && usuario.getPresupuesto() >= atraccion.getPrecio()
						&& usuario.getTiempoDisponible() >= atraccion.getDuracion()) {
					atraccionesRecomendadas.add(atraccion);
				}
			}
		}
		return atraccionesRecomendadas;
	}

	public static List<Atraccion> sugerenciasOtrasAtracciones(Usuario usuario) {
			List<Atraccion> otrasAtracciones = new ArrayList<Atraccion>();
			
			
			for (Atraccion atraccion : listaAtracciones) {
				if ((usuario.getTipoPreferido()).compareTo(atraccion.getTipo()) != 0) {
					if (atraccion.getCupoPersonas() > 0 && usuario.getPresupuesto() >= atraccion.getPrecio()
							&& usuario.getTiempoDisponible() >= atraccion.getDuracion()) {
						otrasAtracciones.add(atraccion);
					}
				}
			}
			return otrasAtracciones;
		}

	public static void mostrarAtracciones(List<Atraccion> atraccionesParaMostrar) {
		List<Atraccion> atracciones = atraccionesParaMostrar;
		int cantidad = 0;
		for (Atraccion atraccion : atracciones) {
			cantidad++;
			System.out.println(cantidad + " - " + atraccion.getNombre() + ": su precio es de " + atraccion.getPrecio()
					+ " monedas, debe tener disponible " + atraccion.getDuracion() + " hs. y su cupo es de "
					+ atraccion.getCupoPersonas() + " personas.");
		}
	}

	public static TipoAtraccion tipoAtraccionGratis(Promocion promocion) {
		String gratis = promocion.visitaGratis();
		TipoAtraccion tipo_gratis = null;
		for (Atraccion atraccion : listaAtracciones) {
			if (gratis.trim().compareTo((atraccion.getNombre()).trim()) == 0) {
				tipo_gratis = atraccion.getTipo();
			}
		}
		return tipo_gratis;
	}
	

	public static List<Promocion> sugerenciasPromociones(Usuario usuario) {
        List<Promocion> promocionesRecomendadas = new ArrayList<Promocion>();
        List<Atraccion> atraccionesP = new ArrayList<Atraccion>();
        for (Promocion promocion : listaPromociones) {
        	atraccionesP = promocion.getAtracciones();
        	int c = 0;
            if (promocion.tipoPromocion() == 3 || promocion.tipoPromocion() == 2 || promocion.tipoPromocion() == 1)
                promocionesRecomendadas.add(promocion);
        }
        return promocionesRecomendadas;
    }

	public static void ordenarAtraccionesPorPrecioYDuracion(List<Atraccion> listaAtracciones) {
		Collections.sort(listaAtracciones, new AtraccionComparator());
	}

	public static void mostrarUsuarios() {
		int p = 0;
		// creamos el iterator para recorrer la lista sin ordenar
		Iterator<Usuario> itinerarioUsuarios = listaUsuarios.iterator();

		// imprime la lista sin ordenar
		while (itinerarioUsuarios.hasNext()) {
			Usuario usuario = itinerarioUsuarios.next();
			p += 1;
			System.out.println(p + " - " + usuario.getNombre() + "------>   Atraccion preferida:"
					+ usuario.getTipoPreferido() + " - Presupuesto: " + usuario.getPresupuesto() + " monedas"
					+ " - Tiempo disponible: " + usuario.getTiempoDisponible() + " hs.");
		}

	}

	public static void generarItinerario(Usuario usuario) {

		if (usuario.getPromocionesAdquiridas().isEmpty() && usuario.getAtraccionesAdquiridas().isEmpty()) {
			System.out.println("Aún no adquirió ningún servicio!");
		} else {
			System.out.println("\nSu itinerario es:");
			double precio = 0;
			double horas = 0;

			if (!(usuario.getPromocionesAdquiridas().isEmpty())) {
				List<Promocion> promocionesAdquiridas = usuario.getPromocionesAdquiridas();
				System.out.println("\nPromociones Adquiridas:");
				for (Promocion promocion : promocionesAdquiridas) {
					precio += promocion.getPrecio();
					horas += promocion.getTiempoPromocion();
					List<Atraccion> atraccionesPromo = promocion.getAtracciones();

					System.out.println("\nPromocion: " + promocion.getNombre() + ", precio: " + promocion.getPrecio()
							+ " monedas, duracion: " + promocion.getTiempoPromocion() + " hs., visita gratis: "
							+ promocion.visitaGratis());
					System.out.println("\nAtracciones Incluidas:");
					for (Atraccion atraccion : atraccionesPromo) {
						System.out.println("\n* " + atraccion.getNombre());
					}
				}

			}

			if (!(usuario.getAtraccionesAdquiridas().isEmpty())) {
				List<Atraccion> atraccionesAdquiridas = usuario.getAtraccionesAdquiridas();
				System.out.println("\nAtracciones Adquiridas:");

				for (Atraccion atraccion : atraccionesAdquiridas) {
					precio += atraccion.getPrecio();
					horas += atraccion.getDuracion();
					System.out.println(
							"---------------------------------------------------------------------------------------------------------------------------------");
					System.out.println("\nAtraccion: " + atraccion.getNombre() + ", precio: " + atraccion.getPrecio()
							+ " monedas, duracion: " + atraccion.getDuracion() + " hs.");
				}
			}

			System.out.println("\nCosto total: " + precio + " monedas, tiempo empleado: " + horas + " hs.");

		}
	}

	public static void generarArchivo(Usuario usuarioActual) {
		String url = "./Archivos/Itinerarios/";

		try {
			String contenido = "";

			contenido = "Nombre: " + usuarioActual.getNombre();
			contenido += "\n==================================================================================";
			contenido += "\nItinerario elegido: ";
			contenido += "\n==================================================================================";

			if (!(usuarioActual.getPromocionesAdquiridas().isEmpty())) {
				contenido += "\nPromociones Compradas:";
				for (Promocion promo : usuarioActual.getPromocionesAdquiridas()) {
					contenido += "\n----------------------------------------------------------------------------------";
					contenido += "\nPromocion: " + promo.getNombre() + ", precio: " + promo.getPrecio()
							+ " monedas, duracion: " + promo.getTiempoPromocion() + " horas.";
				}

			} else {
				contenido += "\n------------------------------------------------------------------------------------";
				contenido += "\n Usted no ha adquirido ninguna promocion";
				contenido += "\n------------------------------------------------------------------------------------";
			}
			if (!(usuarioActual.getAtraccionesAdquiridas().isEmpty())) {
				contenido += "\nAtracciones adquiridas";
				contenido += "\n----------------------------------------------------------------------------------";
				for (Atraccion atr : usuarioActual.getAtraccionesAdquiridas()) {
					contenido += "\nAtraccion" + atr.getNombre() + ", precio: " + atr.getPrecio()
							+ " monedas, duracion: " + atr.getDuracion() + " horas";
				}
			} else {
				contenido += "\n------------------------------------------------------------------------------------";
				contenido += "\n Usted no ha adquirido ninguna atraccion";
				contenido += "\n------------------------------------------------------------------------------------";
			}

			File archivo = new File(url);

			if (!archivo.exists()) {
				archivo.createNewFile();
			}

			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(contenido);
			bw.close();

		} catch (Exception e) {

			// TODO: handle exception
			e.printStackTrace();

		}
		System.out.println("Archivo generado exitosamente!");

	}
	
	public static void mostrarPromociones(List<Promocion> promocionesMostrar) {
		List<Promocion> promociones = promocionesMostrar;
		int cant = 0;
		for (Promocion promocion : promociones) {
			cant++;
			System.out.print(cant + " - " + promocion.getNombre() + " - Destinos: ");
			for (Atraccion atraccion : promocion.getAtracciones()) {
				System.out.print(atraccion.getNombre() + ",");
			}
			System.out.println(promocion.visitaGratis() + ". Precio de la promo: " + promocion.getPrecio()
					+ " monedas, duracion: " + promocion.getTiempoPromocion() + " hs.");
		}
	}
	
	public static List<Atraccion> analizarPromocion(String[] lectura) {
		List<Atraccion> atracciones = new ArrayList<>();
		for (int x = 1; x <= (lectura.length - 2); x++) {
			atracciones.add(buscadorAtraccion(lectura[x]));
		}
		return atracciones;
	}
	
	
	public static void main(String[] args) {
		
		readUsuariosFileAndCreateList();
		consola();

	}

}

	

