package tpTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionarAtracciones {

	public List<Atraccion> readUsuariosFileAndCreateList() {

		FileReader fr = null;
		BufferedReader br = null;

		List<Atraccion> listaAtracciones = new ArrayList<>(); // conviene list o LINkList?3

		try {

			fr = new FileReader("Archivos/Atracciones.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while ((linea != null)) {
				String[] valores = linea.split(",");

				String nombre = valores[0];
				int costo = Integer.parseInt(valores[1]);
				double tiempo = Integer.parseInt(valores[2]);
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

}
