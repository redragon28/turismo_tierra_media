package tpTierraMedia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionarUsuarios {

	public List<Usuario> readUsuariosFileAndCreateList() {


		FileReader fr = null;
		BufferedReader br = null;
		
		List<Usuario> listaUsuarios = new ArrayList<>();

		try {

			fr = new FileReader("Archivos/Usuarios.txt");
			br = new BufferedReader(fr);

			String linea = br.readLine();
			while ((linea != null)) {
				String[] valores = linea.split(",");
				Usuario nuevoUsuario = new Usuario(valores[0], (int) Double.parseDouble(valores[1]),
						(int) Double.parseDouble(valores[2], valores[3]));
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
}
