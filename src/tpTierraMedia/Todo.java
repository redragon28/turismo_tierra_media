package tpTierraMedia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Todo {
	
	private static List<Promocion> listaPromociones = GestionarPromociones.readPromocionFileAndCreateList();
	private static List<Atraccion> listaAtracciones = GestionarAtracciones.readAtraccionesFileAndCreateList();
	private static List<Usuario> listaUsuarios=GestionarUsuarios.readUsuariosFileAndCreateList();
	
	
	
	
	
}