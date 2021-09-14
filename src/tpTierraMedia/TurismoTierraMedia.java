package tpTierraMedia;

import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TurismoTierraMedia {
	private static List<Atraccion> listaAtracciones;
	private static List<Promocion> listaPromociones;
	private static List<Usuario> listaUsuarios;

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
		while (eleccion != 1000) {
			if (cant_promos != 0 && (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1)) {
				sugerirPromociones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
						eleccion);
<<<<<<< HEAD
			} else if (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1) {
				sugerirAtraccionesPreferidas(usuario, promocionesRecomendadas, atraccionesRecomendadas,
						otrasAtracciones, eleccion);
			} else if (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1) {
=======
			} else if (cant_atrac != 0 && (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1)) {
				sugerirAtraccionesPreferidas(usuario, promocionesRecomendadas, atraccionesRecomendadas,
						otrasAtracciones, eleccion);
			} else if (cant_otrasAtrac != 0 && (usuario.getPresupuesto() >= 3 || usuario.getTiempoDisponible() >= 1)) {
>>>>>>> 131ff49df546cca0551b8f63d6621b85dd8f3569
				sugerirOtrasAtracciones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
						eleccion);
			} else {
				listaUsuarios.remove(usuario);

			}
		}
	}

	public static void sugerirPromociones(Usuario usuario, List<Promocion> promocionesRecomendadas,
			List<Atraccion> atraccionesRecomendadas, List<Atraccion> otrasAtracciones, int eleccion) {
		while (!promocionesRecomendadas.isEmpty()) {
			if (usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1) {
				// usuarioSinAtracciones(usuario, eleccion);
				System.out.println("No puedes realizar compras!");
				listaUsuarios.remove(usuario);
			}
			System.out.println("\nEstas son las atracciones que recomendamos para usted:");
			ordenarAtraccionesPorPrecioYDuracion(atraccionesRecomendadas);
			mostrarAtracciones(atraccionesRecomendadas);
			System.out.println("\nUsted tiene: " + usuario.getPresupuesto() + " monedas y "
					+ usuario.getTiempoDisponible() + " hs disponibles.");
			System.out.println("\nSi desea obtener una atraccion, por favor ingrese su numero");
			System.out.println("\nSi ya no desea continuar, escriba exit!");

			Scanner sc = new Scanner(new InputStreamReader(System.in));
			boolean exit = false;
			while (!exit) {
				String valorEntrada = sc.nextLine();

				if (valorEntrada.equalsIgnoreCase("exit!")) {
					exit = true;
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
	}

	public static void sugerirAtraccionesPreferidas(Usuario usuario, List<Promocion> promocionesRecomendadas,
			List<Atraccion> atraccionesRecomendadas, List<Atraccion> otrasAtracciones, int eleccion) {
		while (!atraccionesRecomendadas.isEmpty()) {
			if (usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1) {
				// usuarioSinAtracciones(usuario, eleccion);
				System.out.println("No puedes realizar compras!");
				listaUsuarios.remove(usuario);
			}
			System.out.println("\nAtracciones recomendadas para usted:");
			ordenarAtraccionesPorPrecioYDuracion(atraccionesRecomendadas);
			mostrarAtracciones(atraccionesRecomendadas);
			System.out.println("\nUsted tiene: " + usuario.getPresupuesto() + " monedas y "
					+ usuario.getTiempoDisponible() + " hs disponibles.");
			System.out.println("\nSi desea obtener una atraccion, por favor ingrese su numero");
			System.out.println("\nSi ya no desea continuar, escriba exit!");

			Scanner sc = new Scanner(new InputStreamReader(System.in));
			boolean exit = false;
			while (!exit) {
				String valorEntrada = sc.nextLine();

				if (valorEntrada.equalsIgnoreCase("exit!")) {
					exit = true;
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
	}

	public static void sugerirOtrasAtracciones(Usuario usuario, List<Promocion> promocionesRecomendadas,
			List<Atraccion> atraccionesRecomendadas, List<Atraccion> otrasAtracciones, int eleccion) {
		while (!atraccionesRecomendadas.isEmpty()) {
			if (usuario.getPresupuesto() < 3 || usuario.getTiempoDisponible() < 1) {
				// usuarioSinAtracciones(usuario, eleccion);
				System.out.println("No puedes realizar compras!");
				listaUsuarios.remove(usuario);
			}
			System.out.println("\nAtracciones recomendadas para usted:");
			ordenarAtraccionesPorPrecioYDuracion(otrasAtracciones);
			mostrarAtracciones(otrasAtracciones);
			System.out.println("\nUsted tiene: " + usuario.getPresupuesto() + " monedas y "
					+ usuario.getTiempoDisponible() + " hs disponibles.");
			System.out.println("\nSi desea obtener una atraccion, por favor ingrese su numero");
			System.out.println("\nSi ya no desea continuar, escriba exit!");

			Scanner sc = new Scanner(new InputStreamReader(System.in));
			boolean exit = false;
			while (!exit) {
				String valorEntrada = sc.nextLine();

				if (valorEntrada.equalsIgnoreCase("exit!")) {
					exit = true;
					sugerirPromociones(usuario, promocionesRecomendadas, atraccionesRecomendadas, otrasAtracciones,
							eleccion);
					try {
						if (valorEntrada.matches("-?\\d+(\\.,0\\d+)?")) {
							eleccion = (int) Double.parseDouble(valorEntrada);
							System.out.println("\nHas elegido la promocion: "
									+ promocionesRecomendadas.get(eleccion - 1).getNombre());

							// Se actualizan horas, presupuesto e historial de promociones del usuario
							actualizarUsuarioPromocion(usuario, promocionesRecomendadas, eleccion - 1);
							actualizarPromocionesAdquiridas(usuario, promocionesRecomendadas, eleccion - 1);
							actualizarCupoAtraccion(atraccionesRecomendadas, eleccion - 1);

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

	public static void actualizarCupoAtraccionPromo(List<Promocion> promociones, int opcion) {
		List<Atraccion> atraccionesPromo = new ArrayList<Atraccion>();
		for (Atraccion a : listaAtracciones) {
			atraccionesPromo = promociones.get(opcion).getAtracciones();
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
	/*
	 * public static void usuarioSinAtracciones(Usuario usuario, int eleccion) {
	 * System.out.println("\nNo puede acceder a las atracciones");
	 * generarArchivoUsuario(usuario); eleccion = 99999; mostrarItinerario(usuario);
	 * listaUsuarios.remove(usuario); consola(); }
	 */

	public static List<Promocion> sugerenciasPromociones(Usuario usuario) {
		List<Promocion> promocionesRecomendadas = new ArrayList<Promocion>();
		for (Promocion promocion : listaPromociones) {
			if (promocion.tipoPromocion() == 3 || promocion.tipoPromocion() == 2 || promocion.tipoPromocion() == 1)
				promocionesRecomendadas.add(promocion);
		}
		return promocionesRecomendadas;
	}

<<<<<<< HEAD
	/*
	 * public static List<Atraccion> actualizarListaAtracciones(Usuario usuario) {
	 * List<Atraccion> atraccionesActualizada = new ArrayList<Atraccion>();
	 * 
	 * for (Atraccion atraccion : listaAtracciones) { if
	 * (!(usuario.getTodasLasAtracciones().contains(atraccion))) {
	 * atraccionesActualizada.add(atraccion); } } return atraccionesActualizada; }
	 * 
	 * public static void actualizarUsuarioPromocion(Usuario usuario,
	 * List<Promocion> promociones, int eleccion) { usuario.setPresupuesto((int)
	 * (usuario.getPresupuesto() - promociones.get(eleccion).costoPromocion()));
	 * usuario.setTiempoDisponible(usuario.getTiempoDisponible() -
	 * promociones.get(eleccion).tiempoPromocion()); }
	 * 
	 * public static void actualizarHistorialAtraccionesDelUsuario(Usuario usuario,
	 * List<Atraccion> atracciones, int opcion) {
	 * usuario.getHistorialDeAtracciones().add(atracciones.get(opcion));
	 * usuario.getTodasLasAtracciones().add(atracciones.get(opcion)); }
	 * 
	 * public static void actualizarCupoAtraccion(List<Atraccion> atracciones, int
	 * i) { atracciones.get(i).setCupoPersonas(atracciones.get(i).getCupoPersonas()
	 * - 1); }
	 */

=======
>>>>>>> 131ff49df546cca0551b8f63d6621b85dd8f3569
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

	public void generarArchivo(Usuario usuarioActual) {



		try {
			String url = ".\\Archivos\\Itinerarios\\"+ usuarioActual.getNombre() +".txt";
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
			
			 if (archivo.createNewFile()) {
			        System.out.println("Archivo creado: " + archivo.getName());
			      } else {
			        System.out.println("El archivo ya existe.");
			      }
			
			FileWriter fw = new FileWriter(archivo);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(contenido);
			bw.close();

		} catch (Exception e) {


			e.printStackTrace();
			// TODO: handle exception
			e.printStackTrace();

		}
		
	}
}
