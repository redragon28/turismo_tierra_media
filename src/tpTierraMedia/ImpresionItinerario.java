package tpTierraMedia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

public class ImpresionItinerario {
	public static void generarArchivo(Usuario usuarioActual, List<Promocion> lista , List <Atraccion> lista2) {
		String url = "./Archivos/Itinerario/";

		try {
			String contenido = "";

			contenido = "Nombre: " + usuarioActual.getNombre();
			contenido += "\n==================================================================================";
			contenido += "\nItinerario elegido: ";
			contenido += "\n==================================================================================";

			if (!lista.isEmpty()) {
				contenido += "\nAdquisiciones Obtenidas:";
				for (Promocion promo : lista	) {
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
				for (Atraccion atr : lista2) {
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
			e.printStackTrace();

		}
		System.out.println("Archivo generado exitosamente!");

	}
;

	

}



